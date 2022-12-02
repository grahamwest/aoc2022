package org.grahamwest.aoc2022;

import org.grahamwest.aoc2022.util.Input;
import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalInt;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class AdventOfCodeTest {

    @Test
    public void dec1part1() {
        int top = Input.asInts(1, -1)
                .split( x -> x < 0)
                .mapToInt(IntStream::sum)
                .top(1)
                .sum();

        Assert.assertEquals(69289, top);
        System.out.println(top);
    }

    @Test
    public void dec1part2() {
        int sumTop3 = Input.asInts(1, -1)
                .split( x -> x < 0)
                .mapToInt(IntStream::sum)
                .top(3)
                .sum();

        Assert.assertEquals(205615, sumTop3);
        System.out.println(sumTop3);
    }

}