package ru.hh.school.sequence;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

class IndexQualifier {

    private static final BigInteger NINE = valueOf(9);
    private static final BigInteger TEN = valueOf(10);

    BigInteger getIndexInSequence(FirstNumber firstNumber) {

        BigInteger value = firstNumber.getValue();

        BigInteger temp = value.subtract(ONE);

        BigInteger origin = ONE;
        BigInteger sum = ONE;

        for (int i = 1; true; i++) {
            BigInteger nextOrigin = origin.multiply(TEN);

            if (value.compareTo(nextOrigin) <= 0) {
                sum = sum.add(temp.multiply(valueOf(i)));
                break;
            }

            BigInteger increment = NINE.multiply(origin).multiply(valueOf(i));
            sum = sum.add(increment);
            temp = temp.subtract(NINE.multiply(origin));
            origin = nextOrigin;
        }
        return sum.add(valueOf(firstNumber.getStartsFrom()));
    }
}
