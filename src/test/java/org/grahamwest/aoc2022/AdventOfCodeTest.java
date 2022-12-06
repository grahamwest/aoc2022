package org.grahamwest.aoc2022;

import org.grahamwest.aoc2022.containers.Containers;
import org.grahamwest.aoc2022.containers.MoveCommand;
import org.grahamwest.aoc2022.rockpaperscissors.Game;
import org.grahamwest.aoc2022.rucksack.Rucksack;
import org.grahamwest.aoc2022.util.Input;
import org.grahamwest.aoc2022.util.Range;
import org.grahamwest.aoc2022.util.Sets;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
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

    @Test
    public void dec5part1() {
        var input = Input.asStrings("dec5.txt").split(String::isEmpty).toList();
        List<Stack<String>> stacks = Containers.parseStacks(input[0]);

        input[1].map(MoveCommand::from)
                .forEach( cmd -> cmd.exec(stacks, 1) );

        var message = stacks.stream().map(s -> s.isEmpty ? "" : s.peek()).collect(Collectors.joining());
        Assert.assertEquals("FWNSHLDNZ", message);
        System.out.println(message);
    }

    @Test
    public void dec5part2() {
        var input = Input.asStrings("dec5.txt").split(String::isEmpty).toList();
        List<Stack<String>> stacks = Containers.parseStacks(input[0]);

        input[1].map(MoveCommand::from)
                .forEach( cmd -> cmd.exec(stacks, Integer.MAX_VALUE) );

        var message = stacks.stream().map(s -> s.isEmpty ? "" : s.peek()).collect(Collectors.joining());
        Assert.assertEquals("RNRGDNFQG", message);
        System.out.println(message);
    }

    @Test
    public void dec6part1() {
        String str = Input.asStrings("dec6.txt").toList().first();
        int marker = str.findSubstring(4, s -> s.uniqueCodepoints().size() == s.length()).end;

        Assert.assertEquals(1909, marker);
        System.out.println(marker);
    }

    @Test
    public void dec6part2() {
        String str = Input.asStrings("dec6.txt").toList().first();
        int marker = str.findSubstring(14, s -> s.uniqueCodepoints().size() == s.length()).end;

        Assert.assertEquals(3380, marker);
        System.out.println(marker);
    }

}