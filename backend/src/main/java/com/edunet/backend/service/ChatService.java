package com.edunet.backend.service;

import com.edunet.backend.dto.ChatMessageRequest;
import com.edunet.backend.dto.ChatMessageResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ChatService {

    public ChatMessageResponse processMessage(ChatMessageRequest request) {
        String userMsg = request.getMessage().toLowerCase().trim();
        String reply;

        if (userMsg.contains("hello") || userMsg.contains("hi") || userMsg.contains("hey")) {
            reply = "Hello! I am your EduNet AI Assistant. How can I help you today? You can ask me doubts, course info, or help with your studies.";
        } else if (userMsg.contains("doubt")) {
            reply = "You can ask your doubts directly using the 'Ask Doubt' section. Our teachers and mentors will resolve them for you!";
        } else if (userMsg.contains("session") || userMsg.contains("book")) {
            reply = "You can book 1-to-1 mentoring sessions with your teachers through the Sessions tab.";
        } else if (userMsg.contains("course") || userMsg.contains("subject")) {
            reply = "EduNet offers learning resources across various subjects. What specific topic are you studying?";
        } else if (userMsg.contains("java") || userMsg.contains("spring")) {
            reply = "Spring Boot makes building production-ready Java backend applications fast and easy with embedded servers and starter dependencies!";
        } else {
            reply = "Thank you for reaching out! I've received your query: '" + request.getMessage() + "'. Let me know if you need help with any specific topic or study material.";
        }

        return new ChatMessageResponse(reply, LocalDateTime.now());
    }
}
