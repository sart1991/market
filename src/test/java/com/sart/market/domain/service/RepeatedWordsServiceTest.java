package com.sart.market.domain.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
public class RepeatedWordsServiceTest {

    @Autowired
    private RepeatedWordsService repeatedWordsService;

    @Test
    void testCountRepeatedWords() {
        String evaluationText = "sasda1sasda2sasda3sasda4jdfvnjfvn";
        String searchCriteria = "sasda";
        long countResult = repeatedWordsService.countRepeatedWords(evaluationText, searchCriteria);
        Assert.isTrue(countResult == 4, "Wrong count result");
    }

}
