package ru.hh.school.utils.io;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author timurnav
 *         on 30.09.2016.
 */
public class ConsoleIoAdapter implements IoAdapter {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public int readInt() {
        return scanner.nextInt();
    }

    @Override
    public void writeLines(Object... lines) {
        Arrays.stream(lines).forEach(System.out::println);
    }
}
