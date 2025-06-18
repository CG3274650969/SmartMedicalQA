package com.ruoyi.system.controller;

import com.ruoyi.system.domain.AiModel;
import com.ruoyi.system.domain.AiModelConfig;
import com.ruoyi.system.domain.AiPromptTemplate;
import com.ruoyi.system.domain.chat.ChatMessage;
import com.ruoyi.system.service.ChatMessageService;
import com.ruoyi.system.service.IAiModelConfigService;
import com.ruoyi.system.service.IAiModelService;
import com.ruoyi.system.service.IAiPromptTemplateService;
import com.ruoyi.system.spark.BigModelNew;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/system/chat")
public class ChatController {

    @Resource
    private ChatMessageService chatService;

    @Resource
    private IAiModelService aiModelService;

    @Resource
    private IAiModelConfigService aiModelConfigService;

    @Resource
    private IAiPromptTemplateService promptTemplateService;

    // ① 创建会话（返回模拟会话ID）
    @PostMapping("/conversation/create")
    public Long createConversation(@RequestBody ChatMessage chat) {
        return System.currentTimeMillis();
    }

    // ② 发送消息并返回大模型回复
    @PostMapping("/ask")
    public String ask(@RequestBody ChatMessage chat) {
        chatService.save(chat);

        String modelName = chat.getModelName();

        // 默认配置（静态兜底）
        String hostUrl = "https://spark-api.xf-yun.com/v3.1/chat";
        String domain = "generalv3";
        String appid = "511216e2";
        String apiSecret = "NmZlZTE3ZDAzMzY1YjgyM2FjYjNlYjQy";
        String apiKey = "e530eff614b1a6f09f1e812bf92bcef1";

        String systemPrompt = "";
        try {
            AiModel model = aiModelService.selectAiModelList(new AiModel())
                    .stream().filter(m -> modelName.equals(m.getName()))
                    .findFirst().orElse(null);

            if (model != null) {
                Long modelId = model.getId();
                AiModelConfig query = new AiModelConfig();
                query.setModelId(modelId);
                List<AiModelConfig> configs = aiModelConfigService.selectAiModelConfigList(query);

                System.out.println("modelId:"+modelId);
                System.out.println("modelName:"+modelName);

                if (!configs.isEmpty()) {
                    AiModelConfig config = configs.get(0);
                    hostUrl = config.getApiEndpoint();
                    domain = config.getDomain();
                    appid = config.getAppid();
                    apiSecret = config.getApiSecret();
                    apiKey = config.getApiKey();

                    System.out.println("加载配置：");
                    System.out.println("hostUrl: " + hostUrl);
                    System.out.println("appid: " + appid);
                    System.out.println("apiSecret: " + apiSecret);
                    System.out.println("apiKey: " + apiKey);
                    System.out.println("domain: " + domain);
                }
            }

            if (model != null) {
                Long modelId = model.getId();
                AiPromptTemplate query = new  AiPromptTemplate();
                query.setModelId(modelId);
                List<AiPromptTemplate> templates = promptTemplateService.selectAiPromptTemplateList(query);

                System.out.println("modelId:"+modelId);
                System.out.println("modelName:"+modelName);

                if (!templates.isEmpty()) {
                    systemPrompt = templates.get(0).getTemplateContent();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "系统错误：" + e.getMessage();
        }


        // 拼接提示词 + 用户输入
        String fullPrompt = systemPrompt + "\n\n病人提问：" + chat.getContent();

        BigModelNew.setNewQuestion(fullPrompt);

        try {
            OkHttpClient client = new OkHttpClient.Builder().build();
            BigModelNew modelInstance = new BigModelNew("chatUI", false, hostUrl, domain, appid, apiSecret, apiKey);
            String authUrl = modelInstance.getAuthUrl();
            String url = authUrl.replace("http://", "ws://").replace("https://", "wss://");
            Request request = new Request.Builder().url(url).build();
            client.newWebSocket(request, modelInstance);

            while (!BigModelNew.isFinished()) {
                Thread.sleep(200);
            }
            String answer = BigModelNew.getAnswer();

            ChatMessage reply = new ChatMessage();
            reply.setConversationId(chat.getConversationId());
            reply.setMessageType(2);
            reply.setContentType(1);
            reply.setContent(answer);
            reply.setIsDeleted(0);
            chatService.save(reply);

            return answer;
        } catch (Exception e) {
            return "系统错误：" + e.getMessage();
        }
    }

    // ③ 跳转聊天页面（GET 方式支持）
    @GetMapping("/ask")
    public String openChat() {
        return "<script>location.href='/chat.html';</script>";
    }

    // ④ 获取可选模型名称
    @GetMapping("/models")
    public List<String> getModelNames() {
        List<AiModel> modelList = aiModelService.selectAiModelList(new AiModel());
        return modelList.stream().map(AiModel::getName).collect(Collectors.toList());
    }
}
