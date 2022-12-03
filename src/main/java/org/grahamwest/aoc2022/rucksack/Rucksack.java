package org.grahamwest.aoc2022.rucksack;

public class Rucksack {

    public static int priority(int codePoint) {
        return priority(codePoint);
    }

    public static int priority(char c) {
        int offset = 'A' - 26;
        if (c >='a' && c <= 'z') {
            offset = 'a';
        }
        return c - offset + 1;
    }

}
