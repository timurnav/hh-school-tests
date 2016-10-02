package ru.hh.school.island;

import ru.hh.school.utils.exceptions.IncorrectInitialDataFormat;
import ru.hh.school.utils.io.IoAdapter;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;
import static ru.hh.school.utils.ParserProxy.safeParse;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
public class IslandsReader {

    private final IslandFactory factory;
    private final IoAdapter ioAdapter;

    public IslandsReader(IoAdapter ioAdapter) {
        factory = new IslandFactory();
        this.ioAdapter = ioAdapter;
    }

    public List<Island> readIslands() {
        ioAdapter.writeLines("Insert data");
        int islandsNumber = ioAdapter.readInt();
        return range(0, islandsNumber)
                .mapToObj(n -> readIsland())
                .map(factory::getIsland)
                .collect(toList());
    }

    private List<String> readIsland() {
        String line = ioAdapter.readLine();
        String[] dimensions = line.split(" ");

        int height = safeParse(dimensions[0]);
        List<String> lines = ioAdapter.readLines(height);

        checkArraysLength(dimensions[1], lines);

        return lines;
    }

    private void checkArraysLength(String dimension, List<String> lines) {
        int width = safeParse(dimension);
        if (!lines.stream().map(s -> s.split(" ")).allMatch(n -> n.length == width)) {
            throw new IncorrectInitialDataFormat("Array has incorrect columns number");
        }
    }

}
