package ru.hh.school.island.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Lake {

    private static int COUNTER = 0;

    private final int id = COUNTER++;

    private final Set<Square> squares = new HashSet<>();

    private int waterLineAltitude;
    private boolean isOmit = false;

    public Lake(Square square, int waterLineAltitude) {
        this.waterLineAltitude = waterLineAltitude;
        this.squares.add(square);
        square.setLake(this);
    }

    public int getWaterLineAltitude() {
        return waterLineAltitude;
    }

    public Set<Square> getCopyOfSquares() {
        return new HashSet<>(squares);
    }

    public void storeExpansion(Collection<Square> currentExtension, int waterLine) {
        waterLineAltitude = waterLine;
        squares.addAll(currentExtension);
        currentExtension.forEach(square -> square.setLake(this));
    }

    public void omit() {
        isOmit = true;
    }

    public void notLake() {
        squares.forEach(square -> square.setLake(null));
    }

    public int getWaterVolume() {
        if (isOmit) {
            return 0;
        }
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
