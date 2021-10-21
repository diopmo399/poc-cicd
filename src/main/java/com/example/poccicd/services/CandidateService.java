package com.example.poccicd.services;


import com.example.poccicd.models.Candidate;

import java.util.List;

public interface CandidateService {

    public List<Candidate> getAllCandidate();
    public Candidate saveCandidate(Candidate candidate);
    public Candidate updateCandidate(Candidate candidate);
    public Candidate findCandidateById(Long id);
    public void deleteCandidate(Long id);
}
