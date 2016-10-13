package ru.hh.school.sequence;

import org.apache.commons.lang3.StringUtils;
import ru.hh.school.sequence.domain.FirstNumberCandidate;
import ru.hh.school.sequence.domain.Sequence;
import ru.hh.school.sequence.service.IndexQualifier;
import ru.hh.school.sequence.service.SequenceHeadNumberCandidatesExtractor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.List;

public class SequenceMain {
    private static SequenceHeadNumberCandidatesExtractor extractor = new SequenceHeadNumberCandidatesExtractor();
    private static IndexQualifier indexQualifier = new IndexQualifier();

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String value = reader.readLine();
            while (StringUtils.isNumeric(value)) {
                Sequence sequence = new Sequence(String.valueOf(value));
                List<FirstNumberCandidate> candidates = extractor.allocateFirstNumberCandidates(sequence);
                BigInteger index = indexQualifier.getIndexInSequence(candidates);
                System.out.println(index);
                value = reader.readLine();
            }
        }
    }
}