package ru.hh.school.sequence.service;

import java.math.BigInteger;

import static java.math.BigInteger.ONE;

/**
 * @author timurnav
 *         on 11.10.2016.
 */
public class NumericStringUtils {

    static String getDecrement(String origin) {
        return new BigInteger(origin).subtract(ONE).toString();
    }

    static String getIncrement(String origin) {
        return new BigInteger(origin).add(ONE).toString();
    }

    static boolean hasOnlyNines(String origin) {
        return origin.matches("^9+$");
    }

    static boolean isSimpleSequence(String sequence) {
        char[] chars = sequence.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] >= chars[i + 1]) {
                return false;
            }
        }
        return true;
    }


}
