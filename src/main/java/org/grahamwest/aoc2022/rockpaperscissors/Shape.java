package org.grahamwest.aoc2022.rockpaperscissors;

import java.util.HashSet;
import java.util.Set;

public enum Shape {

    ROCK, PAPER, SCISSOR;

    public static Shape from(String symbol) {
        return switch(symbol) {
            case "A", "X" -> ROCK;
            case "B", "Y" -> PAPER;
            case "C", "Z" -> SCISSOR;
            default -> throw new RuntimeException("Unknown symbol");
        };
    }

    public int score() {
        return this.ordinal() + 1;
    }

    public int play(Shape opponentShape) {
        if (this.beats(opponentShape)) {
            return 6;
        } else if (this == opponentShape) {
            return 3;
        } else {
            return 0;
        }
    }

    public int outcome(Shape opponentShape) {
        return this.score() + this.play(opponentShape);
    }

    public Shape beats() {
        return switch(this) {
            case ROCK -> SCISSOR;
            case PAPER -> ROCK;
            case SCISSOR -> PAPER;
        };
    }

    public Shape beatenBy() {
        Set<Shape> beatenBy = new HashSet<>( Set.of(Shape.values()) );
        beatenBy.remove(this);
        beatenBy.remove( this.beats() );
        return beatenBy.first();
    }

    public boolean beats(Shape s) {
        return this.beats() == s;
    }

}