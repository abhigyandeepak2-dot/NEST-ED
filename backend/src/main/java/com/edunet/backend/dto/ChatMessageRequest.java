package com.edunet.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class ChatMessageRequest {

    private Long userId;

    @NotBlank(message = "message is required")
    private String message;

    public ChatMessageRequest() {}

    public ChatMessageRequest(Long userId, String message) {
        this.userId = userId;
        this.message = message;
    }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
}
