package org.grahamwest.aoc2022;

import org.grahamwest.aoc2022.rockpaperscissors.Game;
import org.grahamwest.aoc2022.rucksack.Rucksack;
import org.grahamwest.aoc2022.util.Input;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class AdventOfCodeTest {

    @Test
    public void dec1part1() {
        int top = Input.asIntsReplaceEmpty(1, -1)
                .split( x -> x < 0)
                .mapToInt(IntStream::sum)
                .top(1)
                .sum();

        Assert.assertEquals(69289, top);
        System.out.println(top);
    }

    @Test
    public void dec1part2() {
        int sumTop3 = Input.asIntsReplaceEmpty(1, -1)
                .split( x -> x < 0)
                .mapToInt(IntStream::sum)
                .top(3)
                .sum();

        Assert.assertEquals(205615, sumTop3);
        System.out.println(sumTop3);
    }

    @Test
    public void dec2part1() {
        int totalScore = Input.asStrings(2)
                .map(Game::parse)
                .mapToInt(Game::outcome)
                .sum();
        System.out.println(totalScore);
    }

    @Test
    public void dec2part2() {
        int totalScore = Input.asStrings(2)
                .map(Game::parseWithObjective)
                .mapToInt(Game::outcome)
                .sum();
        System.out.println(totalScore);
    }

    @Test
    public void dec3part1() {

        var sumPriorities = Input.asStrings(3)
                .map( code -> {
                    String[] compartments = code.segment(2);
                    return compartments[0].uniqueCodepoints().intersect(compartments[1].uniqueCodepoints()).first();
                })
                .mapToInt(Rucksack::priority)
                .sum();

        Assert.assertEquals(7597, sumPriorities);
        System.out.println(sumPriorities);
    }

    @Test
    public void dec3part2() {

        Function<Integer, Integer> charToPriority = (x) -> {
            int offset = 'A' - 26;
            if (x >='a' && x <= 'z') {
                offset = 'a';
            }
            return x - offset + 1;
        };

        var sumPriorities = Input.asStrings(3)
                .chunk(3)
                .map( groupOfThree -> {
                   var elves = groupOfThree.map(s -> s.uniqueCodepoints()).toList();
                   return elves.get(0).intersect(elves.get(1)).intersect(elves.get(2)).first();
                })
                .mapToInt(s -> charToPriority.apply(s))
                .sum();
        //Assert.assertEquals(7597, sumPriorities);
        System.out.println(sumPriorities);
    }

}