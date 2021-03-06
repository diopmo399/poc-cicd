package com.example.poccicd.controller;


import com.example.poccicd.models.Candidate;
import com.example.poccicd.services.CandidateService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/candidate")
public class CandidateController {

    final private CandidateService candidateService;

    public CandidateController(CandidateService candidateService) {
        this.candidateService = candidateService;
    }

    @GetMapping
    public ResponseEntity<List<Candidate>> getAllCandidate(){
        return ResponseEntity.ok(candidateService.getAllCandidate()) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Candidate> getCandidateById(@PathVariable Long id){
        return ResponseEntity.ok(candidateService.findCandidateById(id));
    }

    @PostMapping
    public ResponseEntity<Candidate> saveCandidate(@RequestBody Candidate candidate){
        return ResponseEntity.status(HttpStatus.CREATED).body(candidateService.saveCandidate(candidate));
    }

    @PutMapping
    public ResponseEntity<Candidate> updateCandidate(@RequestBody Candidate candidate){
        return ResponseEntity.ok(candidateService.updateCandidate(candidate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Long> deleteCandidate(@PathVariable Long id){
        candidateService.deleteCandidate(id);
        return ResponseEntity.ok(id);
    }
}
