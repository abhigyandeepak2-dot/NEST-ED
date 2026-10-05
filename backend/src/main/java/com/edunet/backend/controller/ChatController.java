package com.edunet.backend.controller;

import com.edunet.backend.dto.ChatMessageRequest;
import com.edunet.backend.dto.ChatMessageResponse;
import com.edunet.backend.service.ChatService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "*")
public class ChatController {

    @Autowired
    private ChatService chatService;

    // 1. AI Chatbot endpoint
    @PostMapping("/message")
    public ResponseEntity<ChatMessageResponse> sendMessage(@Valid @RequestBody ChatMessageRequest request) {
        ChatMessageResponse response = chatService.processMessage(request);
        return ResponseEntity.ok(response);
    }
}
