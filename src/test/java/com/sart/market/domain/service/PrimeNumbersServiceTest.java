package com.sart.market.domain.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
public class PrimeNumbersServiceTest {

    @Autowired
    private PrimeNumbersService primeNumbersService;

    @Test
    public void primeNumbersList() {
        int start = 0;
        int end = 100;

        List<Integer> list = primeNumbersService.limitedPrimeNumbersList(start, end);
        Assert.notEmpty(list, "There are no prime numbers in range");
    }

}
