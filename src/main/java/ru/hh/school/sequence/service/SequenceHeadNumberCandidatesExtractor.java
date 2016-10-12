package ru.hh.school.sequence.service;

import ru.hh.school.sequence.domain.FirstNumberCandidate;
import ru.hh.school.sequence.domain.Sequence;

import java.util.List;

/**
 * @author timurnav
 *         on 11.10.2016.
 */
public class SequenceHeadNumberCandidatesExtractor {

    private SearchStrategyProvider strategyProvider = new SearchStrategyProvider();

    public List<FirstNumberCandidate> allocateFirstNumberCandidates(Sequence sequence) {
        return strategyProvider.get(sequence.getValue()).getCandidates(sequence);
    }
}
