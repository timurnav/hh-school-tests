package ru.hh.school.island.service;

import ru.hh.school.island.domain.Island;
import ru.hh.school.island.domain.IslandBuilder;
import ru.hh.school.utils.io.IoAdapter;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.range;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
public class IslandsReader {

    private final IoAdapter ioAdapter;

    public IslandsReader(IoAdapter ioAdapter) {
        this.ioAdapter = ioAdapter;
    }

    public List<Island> readIslands() {
        return range(0, ioAdapter.readInt())
                .mapToObj(n -> readIsland())
                .collect(toList());
    }

    private Island readIsland() {
        int lines = ioAdapter.readInt();
        int columns = ioAdapter.readInt();
        IslandBuilder islandBuilder = new IslandBuilder(lines, columns);

        range(0, lines * columns)
                .mapToObj(n -> ioAdapter.readInt())
                .forEach(islandBuilder::populateNextCell);

        return islandBuilder.build();
    }
}
