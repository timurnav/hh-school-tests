package ru.hh.school.sequence;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
public class IndexQualifier {

    private static final BigInteger NINE = valueOf(9);
    private static final BigInteger TEN = valueOf(10);

    public BigInteger getIndexInSequence(BigInteger value) {

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
        return sum;
    }
}
