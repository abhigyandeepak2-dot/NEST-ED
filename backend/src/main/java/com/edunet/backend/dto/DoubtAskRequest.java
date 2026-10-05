package com.edunet.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DoubtAskRequest {

    @NotNull(message = "studentId is required")
    private Long studentId;

    @NotBlank(message = "subject is required")
    private String subject;

    @NotBlank(message = "question is required")
    private String question;

    public DoubtAskRequest() {}

    public DoubtAskRequest(Long studentId, String subject, String question) {
        this.studentId = studentId;
        this.subject = subject;
        this.question = question;
    }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getQuestion() { return question; }
    public void setQuestion(String question) { this.question = question; }
}
