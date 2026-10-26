package com.edunet.backend.dto;

import java.time.LocalDate;

public class SessionBookingRequest {

    private Long studentId;
    private Long teacherId;
    private String subject;
    private LocalDate sessionDate;
    private String timeSlot;
    private String mode;

    public SessionBookingRequest() {
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public LocalDate getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(LocalDate sessionDate) {
        this.sessionDate = sessionDate;
    }

    public String getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(String timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}