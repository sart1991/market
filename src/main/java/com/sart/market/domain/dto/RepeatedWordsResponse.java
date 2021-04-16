package com.sart.market.domain.dto;

public class RepeatedWordsResponse {

    private long repeatedWordsCount;

    public RepeatedWordsResponse(long repeatedWordsCount) {
        this.repeatedWordsCount = repeatedWordsCount;
    }

    public long getRepeatedWordsCount() {
        return repeatedWordsCount;
    }

    public void setRepeatedWordsCount(long repeatedWordsCount) {
        this.repeatedWordsCount = repeatedWordsCount;
    }
}
