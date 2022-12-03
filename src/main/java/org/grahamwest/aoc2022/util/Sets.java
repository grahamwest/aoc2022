package org.grahamwest.aoc2022.util;

import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class Sets {

    public static <T> Set<T> intersect(Stream<Set<T>> streamOfSets) {
        List<Set<T>> sets = streamOfSets.toList();

        Set<T> intersection = sets.get(0);
        for (int i = 1; i < sets.size(); i++) {
            intersection = intersection.intersect(sets.get(i));
        }

        return intersection;
    }

}
