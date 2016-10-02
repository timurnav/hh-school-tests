package ru.hh.school.sequence;

import java.math.BigInteger;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
public class FirstNumber {

    private final BigInteger firstNumber;
    private final int startsFrom;

    public FirstNumber(BigInteger firstNumber, int startsFrom) {
        this.firstNumber = firstNumber;
        this.startsFrom = startsFrom;
    }
}
