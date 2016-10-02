package ru.hh.school.utils.io;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.util.stream.IntStream.range;

/**
 * @author timurnav
 *         on 30.09.2016.
 */
public class ConsoleIoAdapter implements IoAdapter {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String readLine() {
        return scanner.next();
    }

    @Override
    public List<String> readLines(int n) {
        return range(0, n).mapToObj(a -> readLine()).collect(Collectors.toList());
    }

    @Override
    public int readInt() {
        return scanner.nextInt();
    }

    @Override
    public void writeLines(Object... lines) {
        Arrays.stream(lines).forEach(System.out::println);
    }
}
