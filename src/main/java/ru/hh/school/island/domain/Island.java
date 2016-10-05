package ru.hh.school.island.domain;

import com.google.common.collect.Table;

import java.util.Collection;

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

    public Collection<Square> getSquares() {
        return squares.values();
    }

}
