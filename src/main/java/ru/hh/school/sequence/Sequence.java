package ru.hh.school.sequence;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
class Sequence {

    private final String value;
    private final int length;

    Sequence(String value) {
        this.value = value;
        this.length = value.length();
    }

    BigInteger getValuePart(int index, int length) {
        return new BigInteger(value.substring(index, index + length));
    }

    boolean isValuePartAvailable(int index, int length) {
        return value.length() >= index + length;
    }

    boolean isSimpleSequence(int originLength) {
        String temp = value.substring(0, originLength);
        char[] chars = temp.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars).equals(temp);
    }

    int getLength() {
        return length;
    }

    BigInteger getSequence() {
        return new BigInteger(value);
    }
}
