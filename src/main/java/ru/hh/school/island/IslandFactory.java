package ru.hh.school.island;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.List;

import static ru.hh.school.utils.ParserProxy.safeParse;

/**
 * @author timurnav
 *         on 30.09.2016.
 */
public class IslandFactory {

    public Island getIsland(List<String> list) {
        Table<Integer, Integer, Integer> island = HashBasedTable.create();

        for (int y = 0; y < list.size(); y++) {
            String[] split = list.get(y).split(" ");
            for (int x = 0; x < split.length; x++) {
                island.put(y, x, safeParse(split[x]));
            }
        }

        return new Island(island);
    }
}
