package ru.hh.school.island.domain;

import com.google.common.collect.HashBasedTable;

import java.util.Collection;

/**
 * @author timurnav
 *         on 04.10.2016.
 */
public class IslandBuilder {

    private static int counter = 0;

    private final HashBasedTable<Integer, Integer, Square> island;
    private final int columns;

    public IslandBuilder(int lines, int columns) {
        this.columns = columns;
        this.island = HashBasedTable.create(lines, columns);
    }

    public void populateNextCell(int altitude) {
        int y = counter / columns;
        int x = counter % columns;
        island.put(y, x, new Square(y, x, altitude));
    }

    public Island build() {
        int lastColumnIndex = island.columnKeySet().size() - 1;
        int lastRowIndex = island.rowKeySet().size() - 1;
        markAsElevations(island.row(0).values());
        markAsElevations(island.column(0).values());
        markAsElevations(island.row(lastRowIndex).values());
        markAsElevations(island.column(lastColumnIndex).values());

        return new Island(island);
    }

    private void markAsElevations(Collection<Square> values) {
        values.forEach(Square::setElevation);
    }
}
