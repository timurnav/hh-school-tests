package ru.hh.school.island;

import com.google.common.collect.Table;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author timurnav
 *         on 30.09.2016.
 */
public class Island {

    private final Table<Integer, Integer, Integer> earth;
    private final int lowest;
    private final int highest;

    public Island(Table<Integer, Integer, Integer> earth) {
        this.earth = earth;
        List<Integer> values = new ArrayList<>(earth.values());
        Collections.sort(values);
        lowest = values.get(0);
        highest = values.get(values.size() - 1);
    }

    public int getHighestAltitude() {
        return highest;
    }

    public int getLowestAltitude() {
        return lowest;
    }
}
