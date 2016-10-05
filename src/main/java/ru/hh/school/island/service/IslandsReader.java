package ru.hh.school.island.service;

import ru.hh.school.island.domain.Island;
import ru.hh.school.island.domain.IslandBuilder;
import ru.hh.school.utils.io.IoAdapter;

import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class IslandsReader {

    private final IoAdapter ioAdapter;

    public IslandsReader(IoAdapter ioAdapter) {
        this.ioAdapter = ioAdapter;
    }

    public Stream<Island> readIslandsAsStream() {
        return range(0, ioAdapter.readInt())
                .mapToObj(n -> readIsland());
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
