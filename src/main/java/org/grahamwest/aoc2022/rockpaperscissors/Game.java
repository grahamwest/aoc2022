package org.grahamwest.aoc2022.rockpaperscissors;

public record Game(Shape opponent, Shape player) {

    public static Game parse(String line) {
        String[] moves = line.split(" ");
        return new Game(Shape.from(moves[0]), Shape.from(moves[1]));
    }

    public static Game parseWithObjective(String line) {
        String[] moves = line.split(" ");
        Shape opponentShape = Shape.from(moves[0]);
        return new Game(opponentShape, Objective.from(moves[1]).shapeRecommender(opponentShape));
    }

    public int outcome() {
        return this.player.outcome(this.opponent);
    }

}
