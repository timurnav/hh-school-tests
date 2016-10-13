package ru.hh.school.sequence.service;

import ru.hh.school.sequence.domain.Sequence;

import static ru.hh.school.sequence.service.NumericStringUtils.*;

/**
 * @author timurnav
 *         on 11.10.2016.
 */
public class SequenceAnalyzer {

    private final Sequence sequence;

    public SequenceAnalyzer(Sequence sequence) {
        this.sequence = sequence;
    }

    boolean isSequenceStartingFromElement(String origin, int from) {
        String current = origin;
        int originLength = origin.length();
        for (int i = from + originLength; i < sequence.getLength(); i += originLength) {
            if (hasOnlyNines(current)) {
                originLength++;
            }
            String expectedIncrement = getIncrement(current);
            if (!sequence.isValuePartAvailable(i, originLength)) {
                return expectedIncrement.startsWith(sequence.getValuePart(i));
            }
            String next = sequence.getValuePart(i, originLength);
            if (!expectedIncrement.equals(next)) {
                return false;
            }
            current = next;
        }
        return true;
    }

    String getNumber(int startsFrom, int length) {
        if (length > sequence.getLength() || !sequence.isValuePartAvailable(startsFrom, length)) {
            throw new IllegalArgumentException("I can't create substring for " + sequence.getValue() + " starts from index " + startsFrom + " and length " + length);
        }
        if (startsFrom < 0) {
            String leftPart = sequence.getValuePart(length + startsFrom, -startsFrom);
            if (leftPart.startsWith("0")) {
                return "";
            }
            String rightPart = sequence.getValuePart(0, length + startsFrom);
            if (hasOnlyNines(rightPart)) {
                if (leftPart.matches("^10*$")) {
                    leftPart += "0";
                }
                return getDecrement(leftPart) + rightPart;
            } else {
                return leftPart + rightPart;
            }
        }
        return sequence.getValuePart(startsFrom, length);
    }


}
