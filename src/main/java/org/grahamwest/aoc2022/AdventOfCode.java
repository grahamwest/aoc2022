package org.grahamwest.aoc2022;

import manifold.ext.rt.api.auto;
import org.grahamwest.aoc2022.util.Input;

import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AdventOfCode {

    public auto dec1() {
        int maxCalories = 0;

        int currentCalories = 0;
        List<OptionalInt> calries = Input.asInts(1).toList();
        for (OptionalInt cal : calries) {
            if (cal.isEmpty()) {
                if (currentCalories > maxCalories) {
                    maxCalories = currentCalories;
                }
                currentCalories = 0;
            } else {
                currentCalories += cal.getAsInt();
            }
        }

        /*
        Input.asInts(1)
                .split(x -> x < 0)
                .flatMap(IntStream::sum)
                .top(3)
                .sum();
*/
        return maxCalories;
    }

}
