package com.sart.market.domain.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
public class PrimeNumbersService {

    public List<Integer> limitedPrimeNumbersList(int startingPoint, int endPoint) {
        if (endPoint <= 0) return new ArrayList<>();
        if (endPoint == 1) return Collections.singletonList(1);
        int realStartingPoint = Math.max(startingPoint, 2);
        List<Integer> primesInRange = IntStream.rangeClosed(realStartingPoint, endPoint)
                .filter(n -> IntStream.range(realStartingPoint, n).noneMatch(p -> (n % p) == 0))
                .boxed().collect(Collectors.toList());
        if (startingPoint < 2)
            primesInRange.add(0, 1);
        return primesInRange;
    }

}
