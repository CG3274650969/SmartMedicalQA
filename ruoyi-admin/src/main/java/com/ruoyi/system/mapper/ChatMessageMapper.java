package com.ruoyi.system.mapper;

import com.ruoyi.system.domain.chat.ChatMessage;
import java.util.List;

public interface ChatMessageMapper {
    int insertMessage(ChatMessage msg);
    List<ChatMessage> selectByConversationId(Long conversationId);
}

