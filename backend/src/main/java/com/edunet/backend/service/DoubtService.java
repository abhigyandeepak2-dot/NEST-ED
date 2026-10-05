package com.edunet.backend.service;

import com.edunet.backend.dto.DoubtAskRequest;
import com.edunet.backend.dto.DoubtReplyRequest;
import com.edunet.backend.entity.Doubt;
import com.edunet.backend.repository.DoubtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DoubtService {

    @Autowired
    private DoubtRepository doubtRepository;

    @Autowired
    private NotificationService notificationService;

    // 1. Student naya doubt post karega
    public Doubt askDoubt(DoubtAskRequest request) {
        Doubt doubt = new Doubt(request.getStudentId(), request.getSubject(), request.getQuestion());
        return doubtRepository.save(doubt);
    }

    // 2. Sare doubts ki list lana (latest pehle)
    public List<Doubt> getAllDoubts() {
        return doubtRepository.findAllByOrderByCreatedAtDesc();
    }

    // 3. ID se single doubt fetch karna
    public Doubt getDoubtById(Long id) {
        return doubtRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Doubt not found with ID: " + id));
    }

    // 4. Teacher doubt ka reply dega aur student ko notification jayega
    public Doubt replyToDoubt(Long id, DoubtReplyRequest request) {
        Doubt doubt = getDoubtById(id);

        doubt.setAnswer(request.getAnswer());
        doubt.setStatus(Doubt.Status.ANSWERED);
        doubt.setAnsweredAt(LocalDateTime.now());

        Doubt updatedDoubt = doubtRepository.save(doubt);

        // Student ko notification bhejna
        String notifMsg = "A teacher replied to your doubt on '" + doubt.getSubject() + "'.";
        notificationService.createNotification(doubt.getStudentId(), notifMsg);

        return updatedDoubt;
    }
}
