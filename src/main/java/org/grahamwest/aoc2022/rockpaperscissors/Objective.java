package org.grahamwest.aoc2022.rockpaperscissors;

public enum Objective {

    LOSE, DRAW, WIN;

    public static Objective from(String symbol) {
        return switch(symbol) {
            case "X" -> LOSE;
            case "Y" -> DRAW;
            case "Z" -> WIN;
            default -> throw new RuntimeException("Unknown symbol");
        };
    }

    public Shape shapeRecommender(Shape opponentShape) {
        return switch (this) {
            case LOSE -> opponentShape.beats();
            case DRAW -> opponentShape;
            case WIN -> opponentShape.beatenBy();
        };
    }

}
