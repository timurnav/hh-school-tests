package ru.hh.school.sequence;

import ru.hh.school.sequence.domain.FirstNumberCandidate;
import ru.hh.school.sequence.domain.Sequence;
import ru.hh.school.sequence.service.IndexQualifier;
import ru.hh.school.sequence.service.SequenceHeadNumberCandidatesExtractor;
import ru.hh.school.utils.io.ConsoleIoAdapter;
import ru.hh.school.utils.io.IoAdapter;

import java.math.BigInteger;
import java.util.List;

public class Main {
    private static IoAdapter io = new ConsoleIoAdapter();
    private static SequenceHeadNumberCandidatesExtractor extractor = new SequenceHeadNumberCandidatesExtractor();
    private static IndexQualifier indexQualifier = new IndexQualifier();

    public static void main(String[] args) {
        int value = io.readInt();
        Sequence sequence = new Sequence(String.valueOf(value));
        List<FirstNumberCandidate> candidates = extractor.allocateFirstNumberCandidates(sequence);
        BigInteger index = indexQualifier.getIndexInSequence(candidates);
        io.writeLines(index);
    }
}
