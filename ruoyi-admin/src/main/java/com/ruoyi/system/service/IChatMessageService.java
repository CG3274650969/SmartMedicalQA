package com.ruoyi.system.service;

import java.util.List;

public interface IChatMessageService {
    void saveMessage(com.ruoyi.system.domain.chat.ChatMessage message);
    List<com.ruoyi.system.domain.chat.ChatMessage> getMessages(Long conversationId);
}
