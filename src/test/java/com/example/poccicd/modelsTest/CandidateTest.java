package com.example.poccicd.modelsTest;


import com.example.poccicd.models.Candidate;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CandidateTest {

    //TODO: 07/10/2020 implementer les tests

    private final Long id = 2L;
    private final String firstName = "Mohamed";
    private final String lastName = "DIOP";
    private final String email = "diopmo@ept.sn";
    private Candidate candidate;



    @BeforeEach
    public void init() {

         candidate =  Candidate.builder()
                 .id(id)
                 .firstName(firstName)
                 .lastName(lastName)
                 .email(email)
                 .build();

    }

    @Test
    void crudTest(){

       AssertionsForClassTypes.assertThat(candidate.getId()).isEqualTo(id);
       AssertionsForClassTypes.assertThat(candidate.getFirstName()).isEqualTo(firstName);
       AssertionsForClassTypes.assertThat(candidate.getLastName()).isEqualTo(lastName);
       AssertionsForClassTypes.assertThat(candidate.getEmail()).isEqualTo(email);

    }

}
