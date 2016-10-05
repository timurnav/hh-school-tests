package ru.hh.school.sequence;

import java.math.BigInteger;
import java.util.Arrays;

import static java.lang.String.valueOf;
import static java.math.BigInteger.ONE;

class Sequence {

    private final String value;
    private final int length;

    Sequence(String value) {
        this.value = value;
        this.length = value.length();
    }

    String getValuePart(int index) {
        return value.substring(index);
    }

    String getRawValue() {
        return value;
    }

    int getLength() {
        return length;
    }

    BigInteger getSequence() {
        return new BigInteger(value);
    }

    BigInteger getValuePart(int index, int length) {
        return new BigInteger(value.substring(index, index + length));
    }

    boolean isValuePartAvailable(int index, int length) {
        return value.length() >= index + length;
    }

    boolean isSimpleSequence(int originLength) {
        return isSimpleSequence(0, originLength);
    }

    boolean isSimpleSequence(int fromIndex, int originLength) {
        String temp = value.substring(fromIndex, originLength).replaceAll("0+$", "");
        char[] chars = getSortedCharArray(temp);
        return valueOf(chars).equals(temp);
    }

    int getIndexOfSingleNotNullMinimum() {
        char[] chars = getSortedCharArray(value.replace("0", ""));
        return chars.length > 1 && chars[0] != chars[1]
                ? value.indexOf(chars[0])
                : -1;
    }

    private char[] getSortedCharArray(String temp) {
        char[] chars = temp.toCharArray();
        Arrays.sort(chars);
        return chars;
    }

    BigInteger getSwappedValue(int index) {
        String origin = value.substring(index);
        String appendix = value.substring(0, index);
        if (appendix.matches("^9+$")) {
            return new BigInteger(origin + appendix.replace("9", "0")).subtract(ONE);
        }
        return new BigInteger(origin + appendix);
    }

    @Override
    public String toString() {
        return value;
    }

    boolean isAllNines() {
        return value.matches("^9+$");
    }
}
