package ru.hh.school.island.domain;

/**
 * @author timurnav
 *         on 03.10.2016.
 */
public class Square implements Comparable<Square> {

    private final int y;
    private final int x;
    private final int altitude;

    private Boolean isElevation;
    private Lake lake;

    Square(int y, int x, int altitude) {
        this.y = y;
        this.x = x;
        this.altitude = altitude;
    }

    public boolean isUnexplored() {
        return isElevation == null;
    }

    public Boolean isElevation() {
        return isElevation;
    }

    public Lake getLake() {
        return lake;
    }

    public void setLake(Lake lake) {
        isElevation = false;
        this.lake = lake;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setElevation() {
        isElevation = true;
    }

    @Override
    public int compareTo(Square other) {
        return this.altitude - other.altitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (x != square.x) return false;
        return y == square.y;

    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        String description = isElevation ? "elevation" : lake.toString();
        return "Square{" + x + "x" + y + " - " + altitude + "}"
                + (isElevation != null ? description : "");
    }
}
