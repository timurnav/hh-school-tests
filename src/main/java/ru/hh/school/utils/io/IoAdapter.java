package ru.hh.school.utils.io;

import java.util.List;

/**
 * @author timurnav
 *         on 30.09.2016.
 */
public interface IoAdapter {

    String readLine();

    List<String> readLines(int n);

    int readInt();

    void writeLines(Object... lines);
}
