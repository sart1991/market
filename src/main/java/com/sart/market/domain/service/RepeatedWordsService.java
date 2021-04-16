package com.sart.market.domain.service;

import org.springframework.stereotype.Service;

@Service
public class RepeatedWordsService {

    public long countRepeatedWords(String evaluationText, String searchCriteria) {
        long count = 0;
        if (evaluationText == null || searchCriteria == null ||
        evaluationText.equals("") || searchCriteria.equals("")) return count;
        while (evaluationText.contains(searchCriteria)) {
            evaluationText = evaluationText.replaceFirst(searchCriteria, "");
            count++;
        }
        return count;
    }

}
