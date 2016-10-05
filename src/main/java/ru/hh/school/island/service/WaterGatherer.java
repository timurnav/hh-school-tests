package ru.hh.school.island.service;

import ru.hh.school.island.domain.Island;
import ru.hh.school.island.domain.Lake;
import ru.hh.school.island.domain.Square;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class WaterGatherer {

    private final IslandExplorer islandExplorer;
    private final LakeExplorer lakeExplorer;

    public WaterGatherer(Island island) {
        this.islandExplorer = new IslandExplorer(island);
        this.lakeExplorer = new LakeExplorer(islandExplorer);
    }

    public int gatherWater() {

        Queue<Square> unexploredSquares = islandExplorer.getUnexploredSquares();

        Set<Lake> lakes = new HashSet<>();

        while (!unexploredSquares.isEmpty()) {
            Square current = unexploredSquares.poll();
            if (!current.isUnexplored()) {
                continue;
            }
            int waterLine = islandExplorer.getLowestNeighborAltitude(current);
            if (waterLine < current.getAltitude()) {
                continue;
            }

            Lake lake = new Lake(current, waterLine);
            lakeExplorer.exploreLake(lake);

            if (lake.getWaterLineAltitude() > current.getAltitude()) {
                lakes.add(lake);
            } else {
                lake.notLake();
            }
        }

        return lakes.stream().mapToInt(Lake::getWaterVolume).sum();
    }
}