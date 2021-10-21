package com.example.poccicd.services.impl;


import com.example.poccicd.exceptions.ResourceNotFoundException;
import com.example.poccicd.models.Candidate;
import com.example.poccicd.repositories.CandidateRepository;
import com.example.poccicd.services.CandidateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    public CandidateServiceImpl(CandidateRepository candidateRepository) {
        this.candidateRepository = candidateRepository;
    }

    @Override
    public List<Candidate> getAllCandidate() {
        return candidateRepository.findAll();
    }

    @Override
    public Candidate saveCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    @Override
    public Candidate updateCandidate(Candidate candidate) {
        return candidateRepository.findById(candidate.getId())
                .map(candidate1 -> {
                    return candidateRepository.save(candidate);
                })
                .orElseThrow(()-> new ResourceNotFoundException("Candidate with id: " +
                        candidate.getId() +" does not exist"));
    }

    @Override
    public Candidate findCandidateById(Long id) {
        return candidateRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("candidate with the id : " + id + " doesn't exist"));
    }

    @Override
    public void deleteCandidate( Long id) {
        candidateRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Candidate with id: " +
                        id +" does not exist"));

        candidateRepository.deleteById(id);
    }
}
