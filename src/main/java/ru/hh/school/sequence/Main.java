package ru.hh.school.sequence;

import org.apache.commons.lang3.StringUtils;
import ru.hh.school.utils.exceptions.IncorrectInitialDataFormat;
import ru.hh.school.utils.io.ConsoleIoAdapter;
import ru.hh.school.utils.io.IoAdapter;

import java.math.BigInteger;

/**
 * @author timurnav
 *         on 30.09.2016.
 */
public class Main {
    private static IoAdapter io = new ConsoleIoAdapter();
    private static NumbersComparator numbersComparator = new NumbersComparator();
    private static IndexQualifier indexQualifier = new IndexQualifier();

    public static void main(String[] args) {
        String value = io.readLine();
        if (!StringUtils.isNumeric(value)) {
            throw new IncorrectInitialDataFormat("Init parameter must be a number");
        }
        Sequence sequence = new Sequence(value);
        BigInteger firstElement = numbersComparator.getFirstElementOfSequence(sequence);
        BigInteger index = indexQualifier.getIndexInSequence(firstElement);
        io.writeLines(index);
    }
}
