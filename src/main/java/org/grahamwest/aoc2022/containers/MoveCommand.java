package org.grahamwest.aoc2022.containers;

import java.util.List;
import java.util.Stack;

public record MoveCommand(int numberOfContainers, int from, int to) {

    public static MoveCommand from(String str) {
        String[] parsed = str.split(" ");
        return new MoveCommand(
                Integer.valueOf(parsed[1]),
                Integer.valueOf(parsed[3]),
                Integer.valueOf(parsed[5])
        );
    }

    public void exec(List<Stack<String>> stacks, int maxMoveCapacity) {
        Stack<String> tmp = new Stack<>();
        for (int i = this.numberOfContainers(); i > 0; i--) {
            tmp.push(stacks.get(this.from() - 1).pop());

            if (tmp.size() >= maxMoveCapacity) {
                stacks.get(this.to() - 1).push(tmp.pop());
            }
        }

        while (!tmp.isEmpty()) {
            stacks.get(this.to() - 1).push(tmp.pop());
        }

    }

}
