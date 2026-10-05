package com.edunet.backend.repository;

import com.edunet.backend.entity.Doubt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoubtRepository extends JpaRepository<Doubt, Long> {

    List<Doubt> findByStudentId(Long studentId);

    List<Doubt> findByStatus(Doubt.Status status);

    List<Doubt> findAllByOrderByCreatedAtDesc();
}
