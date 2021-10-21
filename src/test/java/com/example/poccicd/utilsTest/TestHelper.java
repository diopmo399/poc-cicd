package com.example.poccicd.utilsTest;



import com.example.poccicd.models.Candidate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestHelper {

     public final static List<Candidate> CANDIDATES = new ArrayList<>(Arrays.asList(
            Candidate.builder()
                    .id(1L)
                    .email("diopmo@ept.sn")
                    .firstName("Mohamed")
                    .lastName("DIOP")
                    .build(),
            Candidate.builder()
                    .id(2L)
                    .email("diopmo@ept.sn")
                    .firstName("Karim")
                    .lastName("SOW")
                    .build()
    ));
}
