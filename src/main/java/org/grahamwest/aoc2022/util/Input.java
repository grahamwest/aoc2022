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

    public static Stream<String> asStrings(String filename) {
        return Files.lines(getResource(filename));
    }

    public static Stream<OptionalInt> asIntsReplaceEmpty(String filename) {
        return asStrings(filename).map( s -> (s.length() == 0) ? OptionalInt.empty() : OptionalInt.of(Integer.valueOf(s).intValue()));
    }

    public static IntStream asIntsReplaceEmpty(String filename, int emptyValue) {
        return asIntsReplaceEmpty(filename).mapToInt(x -> x.orElse(emptyValue) );
    }

}
