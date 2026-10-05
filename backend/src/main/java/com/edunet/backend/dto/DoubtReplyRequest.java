package com.edunet.backend.dto;

import jakarta.validation.constraints.NotBlank;

public class DoubtReplyRequest {

    @NotBlank(message = "answer is required")
    private String answer;

    public DoubtReplyRequest() {}

    public DoubtReplyRequest(String answer) {
        this.answer = answer;
    }

    public String getAnswer() { return answer; }
    public void setAnswer(String answer) { this.answer = answer; }
}
