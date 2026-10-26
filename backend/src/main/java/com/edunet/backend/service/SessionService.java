package com.edunet.backend.service;

import com.edunet.backend.entity.Session;
import com.edunet.backend.entity.SessionStatus;
import com.edunet.backend.entity.User;
import com.edunet.backend.repository.SessionRepository;
import com.edunet.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;
    private final UserRepository userRepository;

    public SessionService(
            SessionRepository sessionRepository,
            UserRepository userRepository) {

        this.sessionRepository = sessionRepository;
        this.userRepository = userRepository;
    }

    // Book a new session
    public Session bookSession(
            Long studentId,
            Long teacherId,
            String subject,
            java.time.LocalDate sessionDate,
            String timeSlot,
            String mode) {

        User student = userRepository.findById(studentId)
                .orElseThrow(() ->
                        new RuntimeException("Student not found"));

        User teacher = userRepository.findById(teacherId)
                .orElseThrow(() ->
                        new RuntimeException("Teacher not found"));

        if (student.getRole() != User.Role.STUDENT) {
            throw new RuntimeException("Selected user is not a student");
        }

        if (teacher.getRole() != User.Role.TEACHER) {
            throw new RuntimeException("Selected user is not a teacher");
        }

        Session session = new Session();

        session.setStudent(student);
        session.setTeacher(teacher);
        session.setSubject(subject);
        session.setSessionDate(sessionDate);
        session.setTimeSlot(timeSlot);
        session.setMode(mode);
        session.setStatus(SessionStatus.PENDING);

        return sessionRepository.save(session);
    }

    // Get all sessions of a teacher
    public List<Session> getTeacherSessions(Long teacherId) {
        return sessionRepository.findByTeacher_Id(teacherId);
    }

    // Get teacher sessions by status
    public List<Session> getTeacherSessionsByStatus(
            Long teacherId,
            SessionStatus status) {

        return sessionRepository.findByTeacher_IdAndStatus(
                teacherId, status);
    }

    // Update session status
    public Session updateStatus(
            Long id,
            SessionStatus status) {

        Session session = sessionRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Session not found"));

        session.setStatus(status);

        return sessionRepository.save(session);
    }
}