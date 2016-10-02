package ru.hh.school.island;

import ru.hh.school.utils.io.ConsoleIoAdapter;
import ru.hh.school.utils.io.IoAdapter;

/**
 * @author timurnav
 *         on 30.09.2016.
 */
public class Main {

    private static IoAdapter io = new ConsoleIoAdapter();
    private static WaterGatherer waterGatherer = new WaterGatherer();

    public static void main(String[] args) {
//        new IslandFactory(io)
//                .readIslands()
//                .stream()
//                .map(waterGatherer::gatherWater)
//                .forEach(io::writeLines);
    }

}
