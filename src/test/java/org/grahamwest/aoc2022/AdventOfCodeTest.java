package org.grahamwest.aoc2022;

import org.grahamwest.aoc2022.rockpaperscissors.Game;
import org.grahamwest.aoc2022.rucksack.Rucksack;
import org.grahamwest.aoc2022.util.Input;
import org.grahamwest.aoc2022.util.Sets;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

public class AdventOfCodeTest {

    @Test
    public void dec1part1() {
        int top = Input.asIntsReplaceEmpty("dec1.txt", -1)
                .split( x -> x < 0)
                .mapToInt(IntStream::sum)
                .top(1)
                .sum();

        Assert.assertEquals(69289, top);
        System.out.println(top);
    }

    @Test
    public void dec1part2() {
        int sumTop3 = Input.asIntsReplaceEmpty("dec1.txt", -1)
                .split( x -> x < 0)
                .mapToInt(IntStream::sum)
                .top(3)
                .sum();

        Assert.assertEquals(205615, sumTop3);
        System.out.println(sumTop3);
    }

    @Test
    public void dec2part1() {
        int totalScore = Input.asStrings("dec2.txt")
                .map(Game::parse)
                .mapToInt(Game::outcome)
                .sum();
        System.out.println(totalScore);
    }

    @Test
    public void dec2part2() {
        int totalScore = Input.asStrings("dec2.txt")
                .map(Game::parseWithObjective)
                .mapToInt(Game::outcome)
                .sum();
        System.out.println(totalScore);
    }

    @Test
    public void dec3part1() {

        var sumPriorities = Input.asStrings("dec3.txt")
                .map( code -> Sets.intersect(code.segment(2).map(s -> s.uniqueCodepoints())).first())
                .mapToInt(Rucksack::priority)
                .sum();

        Assert.assertEquals(7597, sumPriorities);
        System.out.println(sumPriorities);
    }

    @Test
    public void dec3part2() {

        var sumPriorities = Input.asStrings("dec3.txt")
                .chunk(3)
                .map( groupOfThree -> Sets.intersect(groupOfThree.map(s -> s.uniqueCodepoints())).first() )
                .mapToInt(Rucksack::priority)
                .sum();

        Assert.assertEquals(2607, sumPriorities);
        System.out.println(sumPriorities);
    }

}