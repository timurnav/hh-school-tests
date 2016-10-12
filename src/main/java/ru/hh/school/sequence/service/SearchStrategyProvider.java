package ru.hh.school.sequence.service;

import ru.hh.school.sequence.domain.FirstNumberCandidate;

import java.util.ArrayList;

import static java.util.Collections.singletonList;
import static ru.hh.school.sequence.service.NumericStringUtils.hasOnlyNines;
import static ru.hh.school.sequence.service.NumericStringUtils.isSimpleSequence;

class SearchStrategyProvider {

    IndexSearchStrategy get(String value) {
        if (hasOnlyNines(value)) {

            return sequence -> {
                String number = sequence.getValue().replaceFirst("9", "8");
                return singletonList(new FirstNumberCandidate(number, 1));
            };

        } else if (isSimpleSequence(value)) {

            return sequence -> {
                SequenceAnalyzer analyzer = new SequenceAnalyzer(sequence);
                String candidate = analyzer.getNumber(0, 1);
                String actualValue = analyzer.isSequenceStartingFromElement(candidate, 0)
                        ? candidate
                        : sequence.getValue();
                return singletonList(new FirstNumberCandidate(actualValue, 0));
            };

        } else {
            return sequence -> {
                SequenceAnalyzer analyzer = new SequenceAnalyzer(sequence);
                ArrayList<FirstNumberCandidate> candidates = new ArrayList<>();
                for (int currentLength = 1; currentLength <= sequence.getLength(); currentLength++) {
                    for (int firstElementIndex = 0; firstElementIndex > -currentLength; firstElementIndex--) {
                        String candidate = analyzer.getNumber(firstElementIndex, currentLength);
                        if (candidate.isEmpty()) {
                            continue;
                        }
                        if (analyzer.isSequenceStartingFromElement(candidate, firstElementIndex)) {
                            candidates.add(new FirstNumberCandidate(candidate, -firstElementIndex));
                        }
                    }
                }
                return candidates;
            };
        }
    }
}
