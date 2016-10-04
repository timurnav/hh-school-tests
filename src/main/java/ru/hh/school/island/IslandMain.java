package ru.hh.school.island;

import ru.hh.school.island.service.IslandsReader;
import ru.hh.school.island.service.WaterGatherer;
import ru.hh.school.utils.io.ConsoleIoAdapter;
import ru.hh.school.utils.io.IoAdapter;

/**
 * @author timurnav
 *         on 30.09.2016.
 */
public class IslandMain {

    private static IoAdapter io = new ConsoleIoAdapter();

    private static WaterGatherer waterGatherer = new WaterGatherer();
    private static IslandsReader islandsReader = new IslandsReader(io);

    public static void main(String[] args) {
        islandsReader
                .readIslands()
                .stream()
                .map(waterGatherer::gatherWater)
                .forEach(io::writeLines);
    }

}
