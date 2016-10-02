package ru.hh.school.sequence;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
public class Sequence {

    private final String value;
    private final int length;

    public Sequence(String value) {
        this.value = value;
        this.length = value.length();
    }

    public BigInteger getValuePart(int index, int length) {
        return new BigInteger(value.substring(index, index + length));
    }

    public boolean isValuePartAvailable(int index, int length) {
        return value.length() >= index + length;
    }

    public boolean isSimpleSequence(int originLength) {
        String temp = value.substring(0, originLength);
        char[] chars = temp.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars).equals(temp);
    }

    public int getLength() {
        return length;
    }

    public BigInteger getSequence() {
        return new BigInteger(value);
    }
}
