package com.example.poccicd.serviceTest;


import com.example.poccicd.exceptions.ResourceNotFoundException;
import com.example.poccicd.models.Candidate;
import com.example.poccicd.repositories.CandidateRepository;
import com.example.poccicd.services.CandidateService;
import com.example.poccicd.services.impl.CandidateServiceImpl;
import com.example.poccicd.utilsTest.TestHelper;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;


public class TestCandidateService {

    @Mock
    private CandidateRepository candidateRepository;

    private CandidateService candidateService;

    @BeforeEach
    public void setup(){

        MockitoAnnotations.initMocks(this);
        candidateService = new CandidateServiceImpl(candidateRepository);

    }

    @Test
    void shouldSavedCandidateSuccessFully(){

        final Candidate candidate = TestHelper.CANDIDATES.get(0);

        given(candidateRepository.save(candidate)).willAnswer(invocation -> invocation.getArgument(0) );

        Candidate saveCandidate = candidateService.saveCandidate(candidate);

        AssertionsForClassTypes.assertThat(saveCandidate).isNotNull();

        verify(candidateRepository).save(any(Candidate.class));
    }

    @Test
    void updateCandidate(){
        final Candidate candidate = TestHelper.CANDIDATES.get(0);

        given(candidateRepository.findById(candidate.getId())).willReturn(Optional.of(candidate));
        given(candidateRepository.save(candidate)).willReturn(candidate);

        final Candidate excepted = candidateService.updateCandidate(candidate);

        AssertionsForClassTypes.assertThat(excepted).isNotNull();

        verify(candidateRepository).save(any(Candidate.class));


    }

    @Test
    void shouldThrowErrorWhenUpdateCandidateWithIdNotExisying(){
        final Candidate candidate = TestHelper.CANDIDATES.get(0);

        given(candidateRepository.findById(candidate.getId())).willReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, ()-> candidateService.updateCandidate(candidate));

        verify(candidateRepository, never()).save(any(Candidate.class));
    }

    @Test
    void shouldReturnFindAll(){
        List<Candidate> candidates = TestHelper.CANDIDATES;

        given(candidateRepository.findAll()).willReturn(candidates);

        List<Candidate> excepted = candidateService.getAllCandidate();

        assertEquals(excepted, candidates);
    }

    @Test
    void findCandidateId(){
        final Long id = TestHelper.CANDIDATES.get(0).getId();
        final Candidate candidate = TestHelper.CANDIDATES.get(0);

        given(candidateRepository.findById(id)).willReturn(Optional.of(candidate));

        final Candidate excepted = candidateService.findCandidateById(id);

        AssertionsForClassTypes.assertThat(excepted).isNotNull();
    }

    @Test
    void deleteCandidate(){
        final Long candidateId = TestHelper.CANDIDATES.get(0).getId();

        given(candidateRepository.findById(candidateId)).willReturn(Optional.of(TestHelper.CANDIDATES.get(0)));

        candidateService.deleteCandidate(candidateId);
        candidateService.deleteCandidate(candidateId);

        verify(candidateRepository, times(2) ).deleteById(candidateId);


    }

}
