package ru.hh.school.sequence;

import java.math.BigInteger;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
class NumbersComparator {

    FirstNumber getFirstElementOfSequence(Sequence sequence) {
        for (int i = 1; i <= sequence.getLength(); i++) {
            if (sequence.getLength() % i != 0) {
                continue;
            }
            FirstNumber firstNumber = getFirstNumber(sequence, i);
            if (firstNumber != null) {
                return firstNumber; //sequence.getValuePart(0, i);
            }
        }
        return new FirstNumber(sequence.getSequence(), 0);
    }

    private FirstNumber getFirstNumber(Sequence sequence, int originLength) {
        if (sequence.isSimpleSequence(originLength)) {
            return checkSimpleSequence(sequence, originLength)
                    ? new FirstNumber(sequence.getValuePart(0, originLength), 0)
                    : null;
        }
        return getFirstNumberOfMixedSequence(sequence, originLength);
    }

    //todo implement
    private FirstNumber getFirstNumberOfMixedSequence(Sequence sequence, int originLength) {
        return null;
    }

    private boolean checkSimpleSequence(Sequence sequence, int originLength) {
        BigInteger origin = sequence.getValuePart(0, originLength);
        for (int i = originLength; i < sequence.getLength(); i += originLength) {
            if (isOriginHasOnlyNines(origin)) {
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

    private boolean isOriginHasOnlyNines(BigInteger origin) {
        for (char c : origin.toString().toCharArray()) {
            if (c != '9') {
                return false;
            }
        }
        return true;
    }

    private boolean isIncrement(BigInteger origin, BigInteger incremented) {
        return origin.add(BigInteger.ONE).equals(incremented);
    }
}
