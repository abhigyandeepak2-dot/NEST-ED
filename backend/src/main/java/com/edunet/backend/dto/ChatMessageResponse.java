package com.edunet.backend.dto;

import java.time.LocalDateTime;

public class ChatMessageResponse {

    private String reply;
    private LocalDateTime timestamp;

    public ChatMessageResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public ChatMessageResponse(String reply) {
        this.reply = reply;
        this.timestamp = LocalDateTime.now();
    }

    public ChatMessageResponse(String reply, LocalDateTime timestamp) {
        this.reply = reply;
        this.timestamp = timestamp;
    }

    public String getReply() { return reply; }
    public void setReply(String reply) { this.reply = reply; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
}
