package ru.hh.school.island.service;

import ru.hh.school.island.domain.Lake;
import ru.hh.school.island.domain.Square;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.emptyList;

public class LakeExplorer {

    private final IslandExplorer explorer;

    public LakeExplorer(IslandExplorer explorer) {
        this.explorer = explorer;
    }

    public void exploreLake(Lake lake) {
        int waterLine = lake.getWaterLineAltitude();
        while (true) {
            Set<Square> lakeSnapshot = lake.getCopyOfSquares();

            List<Square> expansion = getLakeExpansion(lakeSnapshot, waterLine);

            if (!isExpansionAvailable(expansion, lakeSnapshot, waterLine)) {
                lake.storeExpansion(emptyList(), waterLine);
                return;
            }
            boolean newLakeAdded = expansion.stream()
                    .filter(square -> square.getLake() != null && !square.getLake().equals(lake))
                    .count() > 0;

            lake.storeExpansion(expansion, waterLine);
            if (!newLakeAdded) {
                waterLine++;
            }
        }
    }

    private List<Square> getLakeExpansion(Set<Square> currentLake, int finalWaterLine) {

        Stream<Square> lakeShores = currentLake.stream()
                .map(explorer::getNeighbors)
                .flatMap(Collection::stream)
                .filter(square -> !currentLake.contains(square));

        return lakeShores
                .filter(shore -> shore.getAltitude() <= finalWaterLine)
                .collect(Collectors.toList());
    }

    private boolean isExpansionAvailable(List<Square> expansion, Set<Square> lakeSnapshot, int waterLine) {
        for (int i = 0; i < expansion.size(); i++) {
            Square square = expansion.get(i);

            if (square.getAltitude() < waterLine) {
                return false;
            }

            List<Square> neighbors = explorer.getNeighbors(square);
            if (neighbors.size() < 4) {
                return false;
            }
            for (Square neighbor : neighbors) {
                if (lakeSnapshot.contains(neighbor) || expansion.contains(neighbor)) {
                    continue;
                }
                int neighborAltitude = neighbor.getAltitude();
                if (neighborAltitude == waterLine) {
                    expansion.add(neighbor);
                } else if (neighborAltitude < waterLine) {
                    if (neighbor.isPartOfLake()) {
                        Lake lake = neighbor.getLake();
                        expansion.clear();
                        expansion.addAll(lake.getCopyOfSquares());
                        lake.omit();
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}