package com.edunet.backend.controller;

import com.edunet.backend.dto.SessionBookingRequest;
import com.edunet.backend.entity.Session;
import com.edunet.backend.entity.SessionStatus;
import com.edunet.backend.service.SessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    // Book a new session
    @PostMapping("/book")
    public Session bookSession(
            @RequestBody SessionBookingRequest request) {

        return sessionService.bookSession(
                request.getStudentId(),
                request.getTeacherId(),
                request.getSubject(),
                request.getSessionDate(),
                request.getTimeSlot(),
                request.getMode()
        );
    }

    // Get all sessions of a teacher
    @GetMapping("/teacher/{teacherId}")
    public List<Session> getTeacherSessions(
            @PathVariable Long teacherId) {

        return sessionService.getTeacherSessions(teacherId);
    }

    // Get teacher sessions by status
    @GetMapping("/teacher/{teacherId}/status")
    public List<Session> getTeacherSessionsByStatus(
            @PathVariable Long teacherId,
            @RequestParam SessionStatus status) {

        return sessionService.getTeacherSessionsByStatus(
                teacherId, status);
    }

    // Accept / Reject / Complete session
    @PutMapping("/{id}/status")
    public Session updateStatus(
            @PathVariable Long id,
            @RequestParam SessionStatus status) {

        return sessionService.updateStatus(id, status);
    }
}