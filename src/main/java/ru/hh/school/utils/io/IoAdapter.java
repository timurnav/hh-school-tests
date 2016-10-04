package ru.hh.school.utils.io;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/**
 * @author timurnav
 *         on 30.09.2016.
 */
public interface IoAdapter {

    String readLine();

    void writeLines(Object... lines);

    int readInt();

    default List<Integer> readInts(int n) {
        return range(0, n)
                .mapToObj(i -> readInt())
                .collect(toList());
    }

}
