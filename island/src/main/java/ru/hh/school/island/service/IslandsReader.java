package ru.hh.school.island.service;

import ru.hh.school.island.domain.Island;
import ru.hh.school.island.domain.IslandBuilder;

import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.Stream;

import static java.util.stream.IntStream.range;

public class IslandsReader {

    private final Scanner scanner;

    public IslandsReader(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public Stream<Island> readIslandsAsStream() {
        return range(0, scanner.nextInt())
                .mapToObj(n -> readIsland());
    }

    private Island readIsland() {
        int lines = scanner.nextInt();
        int columns = scanner.nextInt();
        IslandBuilder islandBuilder = new IslandBuilder(lines, columns);

        range(0, lines * columns)
                .mapToObj(n -> scanner.nextInt())
                .forEach(islandBuilder::populateNextCell);

        return islandBuilder.build();
    }
}
