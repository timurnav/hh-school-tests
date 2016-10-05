package ru.hh.school.sequence;

import ru.hh.school.utils.io.ConsoleIoAdapter;
import ru.hh.school.utils.io.IoAdapter;

import java.math.BigInteger;

public class Main {
    private static IoAdapter io = new ConsoleIoAdapter();
    private static NumbersComparator numbersComparator = new NumbersComparator();
    private static IndexQualifier indexQualifier = new IndexQualifier();

    public static void main(String[] args) {
        int value = io.readInt();
        Sequence sequence = new Sequence(String.valueOf(value));
        FirstNumber firstElement = numbersComparator.getFirstElementOfSequence(sequence);
        BigInteger index = indexQualifier.getIndexInSequence(firstElement);
        io.writeLines(index);
    }
}
