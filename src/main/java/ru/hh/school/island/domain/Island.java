package ru.hh.school.island.domain;

import com.google.common.collect.Table;

import java.util.LinkedList;
import java.util.Queue;

import static java.util.stream.Collectors.toCollection;

/**
 * @author timurnav
 *         on 30.09.2016.
 */
public class Island {

    private final Table<Integer, Integer, Square> squares;

    Island(Table<Integer, Integer, Square> squares) {
        this.squares = squares;
    }

    public boolean hasSquare(int y, int x) {
        return squares.contains(y, x);
    }

    public Square getSquare(int y, int x) {
        return squares.get(y, x);
    }

    public Queue<Square> getUnexploredSquares() {
        return squares.values()
                .stream()
                .filter(Square::isUnexplored)
                .sorted()
                .collect(toCollection(LinkedList::new));
    }

}
