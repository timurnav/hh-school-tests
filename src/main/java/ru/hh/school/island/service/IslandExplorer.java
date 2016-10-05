package ru.hh.school.island.service;

import ru.hh.school.island.domain.Island;
import ru.hh.school.island.domain.Square;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static java.util.stream.Collectors.toCollection;

public class IslandExplorer {

    private final Island island;

    public IslandExplorer(Island island) {
        this.island = island;
    }

    public Queue<Square> getUnexploredSquares() {
        return island.getSquares().stream()
                .filter(Square::isUnexplored)
                .sorted()
                .collect(toCollection(LinkedList::new));
    }

    @SuppressWarnings("all")
    public int getLowestNeighborAltitude(Square current) {
        return getNeighbors(current)
                .stream()
                .mapToInt(Square::getAltitude)
                .min()
                .getAsInt();
    }

    public List<Square> getNeighbors(Square current) {
        int x = current.getX();
        int y = current.getY();
        ArrayList<Square> neighbors = new ArrayList<>();
        addNeighbor(neighbors, x, y - 1);
        addNeighbor(neighbors, x + 1, y);
        addNeighbor(neighbors, x, y + 1);
        addNeighbor(neighbors, x - 1, y);
        return neighbors;
    }

    private void addNeighbor(ArrayList<Square> neighbors, int x, int y) {
        if (island.hasSquare(y, x)) {
            neighbors.add(island.getSquare(y, x));
        }
    }

}
