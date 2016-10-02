package ru.hh.school.sequence;

import java.math.BigInteger;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
class FirstNumber {

    private final BigInteger value;
    private final int startsFrom;

    FirstNumber(BigInteger value) {
        this(value, 0);
    }

    FirstNumber(BigInteger value, int startsFrom) {
        this.value = value;
        this.startsFrom = startsFrom;
    }

    BigInteger getValue() {
        return value;
    }

    int getStartsFrom() {
        return startsFrom;
    }

    @Override
    public String toString() {
        return value + " from " + startsFrom;
    }
}
