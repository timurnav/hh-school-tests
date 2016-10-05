package ru.hh.school.island;

import ru.hh.school.island.service.IslandsReader;
import ru.hh.school.island.service.WaterGatherer;
import ru.hh.school.utils.io.ConsoleIoAdapter;
import ru.hh.school.utils.io.IoAdapter;

public class IslandMain {

    private static IoAdapter io = new ConsoleIoAdapter();
    private static IslandsReader islandsReader = new IslandsReader(io);

    public static void main(String[] args) {
        islandsReader
                .readIslandsAsStream()
                .map(WaterGatherer::new)
                .map(WaterGatherer::gatherWater)
                .forEach(io::writeLines);
    }
}