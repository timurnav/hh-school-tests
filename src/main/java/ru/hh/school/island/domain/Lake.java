package ru.hh.school.island.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * @author timurnav
 *         on 03.10.2016.
 */
public class Lake {

    private static int COUNTER = 0;

    private final int id = COUNTER++;
    private int waterLineAltitude;
    private Set<Square> squares = new HashSet<>();

    public Lake(Square square, int waterLineAltitude) {
        this.waterLineAltitude = waterLineAltitude;
        this.squares.add(square);
    }

    public void notLake() {
        squares.forEach(Square::setElevation);
    }

    public void merge(Lake other) {
        this.squares.addAll(other.squares);
    }

    public int getWaterVolume() {
        int earthVolume = squares.stream().mapToInt(Square::getAltitude).sum();
        int fullVolume = waterLineAltitude * squares.size();
        return fullVolume - earthVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lake lake = (Lake) o;

        return id == lake.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
