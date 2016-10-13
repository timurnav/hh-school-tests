package ru.hh.school.island;

import ru.hh.school.island.service.IslandsReader;
import ru.hh.school.island.service.WaterGatherer;

public class IslandMain {

    public static void main(String[] args) {
        new IslandsReader(System.in)
                .readIslandsAsStream()
                .map(WaterGatherer::new)
                .map(WaterGatherer::gatherWater)
                .forEach(System.out::println);
    }
}