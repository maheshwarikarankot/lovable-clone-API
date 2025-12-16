package com.backendProject.Lovable_Clone.entity;

import com.backendProject.Lovable_Clone.enums.MessageRole;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ChatMessage {

    Long Id;
    ChatSession chatSession;

    String content;
    String toolCalls; //JSON Array of Tools called

    MessageRole role;

    Integer tokenUsed;
    Instant createdAt;

}
