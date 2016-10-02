package ru.hh.school.sequence;

import java.math.BigInteger;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
public class NumbersComparator {

    public BigInteger getFirstElementOfSequence(Sequence sequence) {
        for (int i = 1; i < sequence.getLength(); i++) {
            if (sequence.getLength() % i != 0) {
                continue;
            }
            if (isValidSequence(sequence, i)) {
                return sequence.getValuePart(0, i);
            }
        }
        return sequence.getSequence();
    }

    private boolean isValidSequence(Sequence sequence, int originLength) {
        if (sequence.isSimpleSequence(originLength)) {
            return checkSimpleSequence(sequence, originLength);
        }
        return checkMixedSequence(sequence, originLength);
    }

    //todo implement
    private boolean checkMixedSequence(Sequence sequence, int originLength) {
        return false;
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
