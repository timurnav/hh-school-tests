package ru.hh.school.sequence.service;

import ru.hh.school.sequence.domain.FirstNumberCandidate;
import ru.hh.school.sequence.domain.Sequence;

import java.util.List;

@FunctionalInterface
public interface IndexSearchStrategy {
    List<FirstNumberCandidate> getCandidates(Sequence sequence);
}
