package com.edunet.backend.repository;

import com.edunet.backend.entity.Session;
import com.edunet.backend.entity.SessionStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {

    List<Session> findByTeacher_Id(Long teacherId);

    List<Session> findByTeacher_IdAndStatus(Long teacherId, SessionStatus status);
}