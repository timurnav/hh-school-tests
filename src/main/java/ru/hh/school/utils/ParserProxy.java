package ru.hh.school.utils;

import ru.hh.school.utils.exceptions.IncorrectInitialDataFormat;

/**
 * @author timurnav
 *         on 01.10.2016.
 */
public class ParserProxy {


    public static int safeParse(String dimension) {
        try {
            return Integer.valueOf(dimension);
        } catch (NumberFormatException e) {
            throw new IncorrectInitialDataFormat("Please specify numbers");
        }
    }

}
