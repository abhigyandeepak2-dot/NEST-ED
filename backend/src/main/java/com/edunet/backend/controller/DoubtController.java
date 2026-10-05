package com.edunet.backend.controller;

import com.edunet.backend.dto.DoubtAskRequest;
import com.edunet.backend.dto.DoubtReplyRequest;
import com.edunet.backend.entity.Doubt;
import com.edunet.backend.service.DoubtService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doubts")
@CrossOrigin(origins = "*")
public class DoubtController {

    @Autowired
    private DoubtService doubtService;

    // 1. Student naya doubt post karega
    @PostMapping("/ask")
    public ResponseEntity<Doubt> askDoubt(@Valid @RequestBody DoubtAskRequest request) {
        Doubt savedDoubt = doubtService.askDoubt(request);
        return new ResponseEntity<>(savedDoubt, HttpStatus.CREATED);
    }

    // 2. Sare doubts ki list fetch karna
    @GetMapping
    public ResponseEntity<List<Doubt>> getAllDoubts() {
        return ResponseEntity.ok(doubtService.getAllDoubts());
    }

    // 3. Single doubt fetch karna by ID
    @GetMapping("/{id}")
    public ResponseEntity<Doubt> getDoubtById(@PathVariable Long id) {
        return ResponseEntity.ok(doubtService.getDoubtById(id));
    }

    // 4. Teacher doubt ka reply dega
    @PostMapping("/{id}/reply")
    public ResponseEntity<Doubt> replyToDoubt(
            @PathVariable Long id,
            @Valid @RequestBody DoubtReplyRequest request) {
        Doubt updatedDoubt = doubtService.replyToDoubt(id, request);
        return ResponseEntity.ok(updatedDoubt);
    }
}
