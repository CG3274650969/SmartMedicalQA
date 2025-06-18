package com.ruoyi.system.service.impl;

import com.ruoyi.system.domain.chat.ChatMessage;
import com.ruoyi.system.mapper.ChatMessageMapper;
import com.ruoyi.system.service.ChatMessageService;
import com.ruoyi.system.service.IChatMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ChatMessageServiceImpl implements ChatMessageService {

    @Resource
    private ChatMessageMapper mapper;

    @Override
    public void save(ChatMessage msg) {
        mapper.insertMessage(msg);
    }

    @Override
    public List<ChatMessage> getByConversationId(Long id) {
        return mapper.selectByConversationId(id);
    }
}

