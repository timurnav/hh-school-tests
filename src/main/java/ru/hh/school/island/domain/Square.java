package ru.hh.school.island.domain;

public class Square implements Comparable<Square> {

    private final int y;
    private final int x;
    private final int altitude;
    private boolean isExplored = false;
    private Lake lake;

    Square(int y, int x, int altitude) {
        this.y = y;
        this.x = x;
        this.altitude = altitude;
    }

    public boolean isUnexplored() {
        return !isExplored;
    }

    public Lake getLake() {
        return lake;
    }

    public void setLake(Lake lake) {
        setExplored();
        this.lake = lake;
    }

    public boolean isPartOfLake() {
        return lake != null;
    }


    public void setExplored() {
        isExplored = true;
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

    @Override
    public int compareTo(Square other) {
        return this.altitude - other.altitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Square square = (Square) o;
        return x == square.x && y == square.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

    @Override
    public String toString() {
        return "Square{" + x + "x" + y + " - " + altitude + "}"
                + (isExplored ? " - explored" : "");
    }
}
