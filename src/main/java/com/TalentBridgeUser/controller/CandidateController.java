package com.TalentBridgeUser.controller;

import com.TalentBridgeUser.dto.CandidateDTO;
import com.TalentBridgeUser.model.Candidate;
import com.TalentBridgeUser.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/candidates")
public class CandidateController {

    private final CandidateService candidateService;

    @Autowired
    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @PostMapping
    public ResponseEntity<?> createCandidate(@RequestBody CandidateDTO request) {
        Candidate candidate = candidateService.createCandidate(
                request.getId(),  // this is userId
                request.getStatus()
        );

        Map<String, Object> response = new HashMap<>();
        response.put("Candidate", candidate);
        response.put("status", "created");

        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidates() {
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }
}
