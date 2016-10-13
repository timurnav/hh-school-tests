package ru.hh.school.sequence;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.hh.school.sequence.domain.FirstNumberCandidate;
import ru.hh.school.sequence.domain.Sequence;
import ru.hh.school.sequence.service.IndexQualifier;
import ru.hh.school.sequence.service.SequenceHeadNumberCandidatesExtractor;

import java.math.BigInteger;
import java.util.List;

public class IndexQualifierTest {

    private final static int N = 10000;

    private SequenceHeadNumberCandidatesExtractor extractor = new SequenceHeadNumberCandidatesExtractor();
    private IndexQualifier indexQualifier = new IndexQualifier();

    private String sequence;

    @Before
    public void init() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < N; i++) {
            stringBuilder.append(i);
        }
        sequence = stringBuilder.toString();
    }

    @Test
    public void getIndexInSequence() throws Exception {
        for (int i = 1; i < N; i++) {
            String value = String.valueOf(i);
            Sequence sequence = new Sequence(value);
            List<FirstNumberCandidate> candidates = extractor.allocateFirstNumberCandidates(sequence);
            BigInteger index = indexQualifier.getIndexInSequence(candidates);
            Assert.assertEquals(
                    index,
                    BigInteger.valueOf(this.sequence.indexOf(value) + 1)
            );
        }
    }
}