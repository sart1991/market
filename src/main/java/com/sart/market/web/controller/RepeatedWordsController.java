package com.sart.market.web.controller;

import com.sart.market.domain.dto.RepeatedWordsRequest;
import com.sart.market.domain.dto.RepeatedWordsResponse;
import com.sart.market.domain.service.RepeatedWordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/repeatedWords/count")
public class RepeatedWordsController {

    @Autowired
    private RepeatedWordsService repeatedWordsService;

    @PostMapping
    public ResponseEntity<RepeatedWordsResponse> countRepeatedWords(@RequestBody RepeatedWordsRequest req) {
        long countResult = repeatedWordsService.countRepeatedWords(req.getEvaluationText(), req.getSearchCriteria());
        return new ResponseEntity<>(new RepeatedWordsResponse(countResult), HttpStatus.OK);
    }

}
