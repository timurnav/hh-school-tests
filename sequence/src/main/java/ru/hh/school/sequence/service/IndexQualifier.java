package ru.hh.school.sequence.service;

import com.google.common.base.Preconditions;
import ru.hh.school.sequence.domain.FirstNumberCandidate;

import java.math.BigInteger;
import java.util.List;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.valueOf;

public class IndexQualifier {

    private static final BigInteger NINE = valueOf(9);
    private static final BigInteger TEN = valueOf(10);

    @SuppressWarnings("all")
    public BigInteger getIndexInSequence(List<FirstNumberCandidate> firstNumber) {
        Preconditions.checkArgument(!firstNumber.isEmpty());
        return firstNumber.stream()
                .map(this::getIndex)
                .sorted()
                .findFirst().get();
    }

    private BigInteger getIndex(FirstNumberCandidate firstNumber) {
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
