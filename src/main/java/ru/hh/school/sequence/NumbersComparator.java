package ru.hh.school.sequence;

import java.math.BigInteger;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
class NumbersComparator {

    FirstNumber getFirstElementOfSequence(Sequence sequence) {
        if (sequence.isAllNines()) {
            return getAllNinesNumber(sequence);
        }
        for (int i = 1; i <= sequence.getLength(); i++) {
            if (sequence.getLength() % i != 0) {
                continue;
            }
            FirstNumber firstNumber = getFirstNumber(sequence, i);
            if (firstNumber != null) {
                return firstNumber;
            }
        }
        return new FirstNumber(sequence.getSequence());
    }

    private FirstNumber getAllNinesNumber(Sequence sequence) {
        return new FirstNumber(new BigInteger(sequence.getRawValue().replaceFirst("9", "8")), 1);
    }

    private FirstNumber getFirstNumber(Sequence sequence, int originLength) {
        if (sequence.isSimpleSequence(originLength)) {
            return checkSimpleSequence(sequence, originLength)
                    ? new FirstNumber(sequence.getValuePart(0, originLength))
                    : null;
        }
        return getFirstNumberOfMixedSequence(sequence, originLength);
    }

    //todo implement
    private FirstNumber getFirstNumberOfMixedSequence(Sequence sequence, int originLength) {
        if (sequence.isValuePartAvailable(0, originLength + 1)) {

        } else {
            return getFirstNumberUsingReplacing(sequence);
        }
        return null;
    }

    private FirstNumber getFirstNumberUsingReplacing(Sequence sequence) {
        int index = sequence.getIndexOfSingleNotNullMinimum();
        if (index != -1) {
            BigInteger value = sequence.getSwappedValue(index);
            if (hasOnlyNines(value)) {
                index--;
            }
            return new FirstNumber(value, index);
        }
        return null;
    }

    private boolean checkSimpleSequence(Sequence sequence, int originLength) {
        BigInteger origin = sequence.getValuePart(0, originLength);
        for (int i = originLength; i < sequence.getLength(); i += originLength) {
            if (hasOnlyNines(origin)) {
                originLength++;
            }
            if (!sequence.isValuePartAvailable(i, originLength)) {
                return false;
            }
            BigInteger next = sequence.getValuePart(i, originLength);
            if (!isIncrement(origin, next)) {
                return false;
            }
            origin = next;
        }
        return true;
    }

    private boolean hasOnlyNines(BigInteger origin) {
        return origin.toString().matches("^9+$");
    }

    private boolean isIncrement(BigInteger origin, BigInteger incremented) {
        return origin.add(BigInteger.ONE).equals(incremented);
    }
}
