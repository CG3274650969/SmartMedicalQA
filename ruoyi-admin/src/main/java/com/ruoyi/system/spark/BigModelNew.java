package com.ruoyi.system.spark;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import okhttp3.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;

// 新增构造函数传入模型配置参数
public class BigModelNew extends WebSocketListener {

    private String hostUrl;
    private String domain;
    private String appid;
    private String apiSecret;
    private String apiKey;

    public static List<RoleContent> historyList = new ArrayList<>();
    public static String totalAnswer = "";
    public static String NewQuestion = "";
    public static final Gson gson = new Gson();

    private String userId;
    private Boolean wsCloseFlag;
    private static Boolean totalFlag = true;

    // ✅ 新构造函数（动态参数）
    public BigModelNew(String userId, Boolean wsCloseFlag,
                       String hostUrl, String domain, String appid, String apiSecret, String apiKey) {
        this.userId = userId;
        this.wsCloseFlag = wsCloseFlag;
        this.hostUrl = hostUrl;
        this.domain = domain;
        this.appid = appid;
        this.apiSecret = apiSecret;
        this.apiKey = apiKey;
    }

    public static void setNewQuestion(String question) {
        NewQuestion = question;
        totalFlag = false;
        totalAnswer = "";
    }

    public static boolean isFinished() {
        return totalFlag;
    }

    public static String getAnswer() {
        return totalAnswer;
    }

    public static boolean canAddHistory() {
        int history_length = 0;
        for (RoleContent temp : historyList) {
            history_length += temp.content.length();
        }
        if (history_length > 12000) {
            for (int i = 0; i < 5 && !historyList.isEmpty(); i++) {
                historyList.remove(0);
            }
            return false;
        } else {
            return true;
        }
    }

    class MyThread extends Thread {
        private WebSocket webSocket;

        public MyThread(WebSocket webSocket) {
            this.webSocket = webSocket;
        }

        public void run() {
            try {
                JSONObject requestJson = new JSONObject();

                JSONObject header = new JSONObject();
                header.put("app_id", appid);
                header.put("uid", UUID.randomUUID().toString().substring(0, 10));

                JSONObject parameter = new JSONObject();
                JSONObject chat = new JSONObject();
                chat.put("domain", domain);
                chat.put("temperature", 0.5);
                chat.put("max_tokens", 4096);
                parameter.put("chat", chat);

                JSONObject payload = new JSONObject();
                JSONObject message = new JSONObject();
                JSONArray text = new JSONArray();

                if (!historyList.isEmpty()) {
                    for (RoleContent temp : historyList) {
                        text.add(JSON.toJSON(temp));
                    }
                }

                RoleContent roleContent = new RoleContent();
                roleContent.role = "user";
                roleContent.content = NewQuestion;
                text.add(JSON.toJSON(roleContent));
                historyList.add(roleContent);

                message.put("text", text);
                payload.put("message", message);

                requestJson.put("header", header);
                requestJson.put("parameter", parameter);
                requestJson.put("payload", payload);

                webSocket.send(requestJson.toString());

                while (true) {
                    Thread.sleep(200);
                    if (wsCloseFlag) break;
                }
                webSocket.close(1000, "");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        super.onOpen(webSocket, response);
        System.out.print("大模型：");
        new MyThread(webSocket).start();
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        JsonParse myJsonParse = gson.fromJson(text, JsonParse.class);
        if (myJsonParse.header.code != 0) {
            System.out.println("错误码：" + myJsonParse.header.code);
            System.out.println("请求 SID：" + myJsonParse.header.sid);
            webSocket.close(1000, "");
        }
        for (Text temp : myJsonParse.payload.choices.text) {
            System.out.print(temp.content);
            totalAnswer += temp.content;
        }
        if (myJsonParse.header.status == 2) {
            System.out.println();
            System.out.println("*************************************************************************************");
            RoleContent roleContent = new RoleContent();
            roleContent.setRole("assistant");
            roleContent.setContent(totalAnswer);
            if (canAddHistory()) {
                historyList.add(roleContent);
            } else {
                historyList.remove(0);
                historyList.add(roleContent);
            }
            wsCloseFlag = true;
            totalFlag = true;
        }
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        super.onFailure(webSocket, t, response);
        if (response != null) {
            try {
                int code = response.code();
                System.out.println("onFailure code: " + code);
                System.out.println("onFailure body: " + response.body().string());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // ✅ 改为非 static
    public String getAuthUrl() throws Exception {
        URL url = new URL(hostUrl);
        SimpleDateFormat format = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));
        String date = format.format(new Date());
        String preStr = "host: " + url.getHost() + "\n" +
                "date: " + date + "\n" +
                "GET " + url.getPath() + " HTTP/1.1";
        Mac mac = Mac.getInstance("hmacsha256");
        SecretKeySpec spec = new SecretKeySpec(apiSecret.getBytes(StandardCharsets.UTF_8), "hmacsha256");
        mac.init(spec);
        byte[] hexDigits = mac.doFinal(preStr.getBytes(StandardCharsets.UTF_8));
        String sha = Base64.getEncoder().encodeToString(hexDigits);
        String authorization = String.format("api_key=\"%s\", algorithm=\"%s\", headers=\"%s\", signature=\"%s\"",
                apiKey, "hmac-sha256", "host date request-line", sha);
        HttpUrl httpUrl = Objects.requireNonNull(HttpUrl.parse("https://" + url.getHost() + url.getPath())).newBuilder()
                .addQueryParameter("authorization", Base64.getEncoder().encodeToString(authorization.getBytes(StandardCharsets.UTF_8)))
                .addQueryParameter("date", date)
                .addQueryParameter("host", url.getHost())
                .build();
        return httpUrl.toString();
    }

    // ✅ 内部类保持不变
    class JsonParse { Header header; Payload payload; }
    class Header { int code; int status; String sid; }
    class Payload { Choices choices; }
    class Choices { List<Text> text; }
    class Text { String role; String content; }

    public static class RoleContent {
        String role;
        String content;
        public String getRole() { return role; }
        public void setRole(String role) { this.role = role; }
        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
    }
}

