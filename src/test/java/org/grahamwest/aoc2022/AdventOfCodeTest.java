package org.grahamwest.aoc2022;

import org.grahamwest.aoc2022.rockpaperscissors.Game;
import org.grahamwest.aoc2022.rucksack.Rucksack;
import org.grahamwest.aoc2022.util.Input;
import org.grahamwest.aoc2022.util.Range;
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
                .map( contents ->
                    Sets.intersect(
                        contents.segment(2)
                            .map(s -> s.uniqueCodepoints())
                    )
                    .first()
                )
                .mapToInt(Rucksack::priority)
                .sum();

        Assert.assertEquals(7597, sumPriorities);
        System.out.println(sumPriorities);
    }

    @Test
    public void dec3part2() {
        var sumPriorities = Input.asStrings("dec3.txt")
                .chunk(3)
                .map( groupOfThree ->
                        Sets.intersect(
                            groupOfThree.map(s -> s.uniqueCodepoints())
                        )
                        .first()
                )
                .mapToInt( Rucksack::priority )
                .sum();

        Assert.assertEquals(2607, sumPriorities);
        System.out.println(sumPriorities);
    }

    @Test
    public void dec4part1() {
        var sum = Input.asStrings("dec4.txt")
                .map(s -> s.split(","))
                .map(s -> (first:Range.from(s[0]), second:Range.from(s[1])))
                .filter(r -> r.first.contains(r.second) || r.second.contains(r.first))
                .count();

        Assert.assertEquals(524, sum);
        System.out.println(sum);
    }

    @Test
    public void dec4part2() {
        var sum = Input.asStrings("dec4.txt")
                .map(s -> s.split(","))
                .map(s -> (first:Range.from(s[0]), second:Range.from(s[1])))
                .filter(r -> r.first.overlaps(r.second))
                .count();

        Assert.assertEquals(798, sum);
        System.out.println(sum);
    }

}