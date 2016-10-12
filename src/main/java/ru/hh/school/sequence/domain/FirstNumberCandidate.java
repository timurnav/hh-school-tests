package ru.hh.school.sequence.domain;

import java.math.BigInteger;

public class FirstNumberCandidate {

    private final BigInteger value;
    private final int startsFrom;

    public FirstNumberCandidate(String value) {
        this(value, 0);
    }

    public FirstNumberCandidate(String value, int startsFrom) {
        this.value = new BigInteger(value);
        this.startsFrom = startsFrom;
    }

    public BigInteger getValue() {
        return value;
    }

    public int getStartsFrom() {
        return startsFrom;
    }

    @Override
    public String toString() {
        return value + " from " + startsFrom;
    }
}
