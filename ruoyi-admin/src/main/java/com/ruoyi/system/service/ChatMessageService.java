package com.ruoyi.system.service;

import com.ruoyi.system.domain.chat.ChatMessage;
import java.util.List;

public interface ChatMessageService {
    void save(ChatMessage msg);
    List<ChatMessage> getByConversationId(Long id);
}

