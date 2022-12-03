package org.grahamwest.aoc2022.util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Input {

    public static Path getResource(String filename) {
        return Path.of(Input.class.getClassLoader().getResource(filename).getPath());
    }

    public static Stream<String> asStrings(int day) {
        return Files.lines(getResource("dec" + day + ".txt"));
    }

    public static Stream<OptionalInt> asIntsReplaceEmpty(int day) {
        return asStrings(day).map( s -> (s.length() == 0) ? OptionalInt.empty() : OptionalInt.of(Integer.valueOf(s).intValue()));
    }

    public static IntStream asIntsReplaceEmpty(int day, int emptyValue) {
        return asIntsReplaceEmpty(day).mapToInt(x -> x.orElse(emptyValue) );
    }

}
