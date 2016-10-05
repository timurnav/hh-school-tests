package ru.hh.school.island.domain;

import com.google.common.collect.HashBasedTable;

import java.util.Collection;

public class IslandBuilder {

    private final HashBasedTable<Integer, Integer, Square> island;
    private final int columns;
    private int counter = 0;

    public IslandBuilder(int lines, int columns) {
        this.columns = columns;
        this.island = HashBasedTable.create(lines, columns);
    }

    public void populateNextCell(int altitude) {
        int y = counter / columns;
        int x = counter++ % columns;
        island.put(y, x, new Square(y, x, altitude));
    }

    public Island build() {
        int lastColumnIndex = island.columnKeySet().size() - 1;
        int lastRowIndex = island.rowKeySet().size() - 1;
        markAsExplored(island.row(0).values());
        markAsExplored(island.column(0).values());
        markAsExplored(island.row(lastRowIndex).values());
        markAsExplored(island.column(lastColumnIndex).values());

        return new Island(island);
    }

    private void markAsExplored(Collection<Square> values) {
        values.forEach(Square::setExplored);
    }
}
