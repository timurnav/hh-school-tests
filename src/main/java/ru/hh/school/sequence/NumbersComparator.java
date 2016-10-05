package ru.hh.school.sequence;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

class NumbersComparator {

    FirstNumber getFirstElementOfSequence(Sequence sequence) {
        if (sequence.isAllNines()) {
            return getAllNinesNumber(sequence);
        }
        for (int i = 1; i <= sequence.getLength(); i++) {
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
            return checkIncrementalSequence(sequence, 0, originLength)
                    ? new FirstNumber(sequence.getValuePart(0, originLength))
                    : null;
        }
        return getFirstNumberOfMixedSequence(sequence, originLength);
    }

    private FirstNumber getFirstNumberOfMixedSequence(Sequence sequence, int originLength) {
        if (sequence.isValuePartAvailable(0, originLength + 1)) {
            for (int i = 1; i < originLength; i++) {
//                sequence.isValuePartAvailable(i, originLength + 1)
            }
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

    private boolean checkIncrementalSequence(Sequence sequence, int from, int originLength) {
        BigInteger origin = sequence.getValuePart(from, originLength);
        for (int i = from + originLength; i < sequence.getLength(); i += originLength) {
            if (hasOnlyNines(origin)) {
                originLength++;
            }
            if (!sequence.isValuePartAvailable(i, originLength)) {
                return canPartBeIncrement(origin, sequence.getValuePart(i));
            }
            BigInteger next = sequence.getValuePart(i, originLength);
            if (!isIncrement(origin, next)) {
                return false;
            }
            origin = next;
        }
        return true;
    }

    private boolean canPartBeIncrement(BigInteger origin, String incrementPart) {
        return origin.add(ONE).toString().startsWith(incrementPart);
    }


    private boolean hasOnlyNines(BigInteger origin) {
        return origin.toString().matches("^9+$");
    }

    private boolean isIncrement(BigInteger origin, BigInteger incremented) {
        return origin.add(ONE).equals(incremented);
    }
}
