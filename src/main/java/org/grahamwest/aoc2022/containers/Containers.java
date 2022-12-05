package org.grahamwest.aoc2022.containers;

import java.util.List;
import java.util.Stack;
import java.util.stream.Stream;

public class Containers {

    private static char[] stacksFromSting(String str) {
        char[] containers = new char[9];
        for (int i = 0; i < containers.length; i++) {
            containers[i] = (str.length() >= (i*4)) ? str.charAt(1 + (i*4)) : ' ';
        }
        return containers;
    }

    public static List<Stack<String>> parseStacks(Stream<String> input) {

        var stackChars = input.map(Containers::stacksFromSting).toList();
        var stacks = Stream.generate(()->new Stack<String>()).limit(10).toList();

        for (int i = stackChars.size() - 2; i >= 0; i--) {
            char[] line = stackChars[i];
            for (int j = 0; j < line.length; j++) {
                Stack<String> stack = stacks.get(j);

                char c = line[j];
                if (c >= 'A' && c <= 'Z') {
                    stack.push(String.valueOf(line[j]));
                }
            }
        }

        return stacks;

    }

}
