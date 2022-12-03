package org.grahamwest.aoc2022.rockpaperscissors;

import org.junit.Assert;
import org.junit.Test;

import static org.grahamwest.aoc2022.rockpaperscissors.Shape.*;

public class PlayTest {

    @Test
    public void testPlays() {

        Assert.assertEquals(3, ROCK.play(ROCK));
        Assert.assertEquals(0, ROCK.play(PAPER));
        Assert.assertEquals(6, ROCK.play(SCISSOR));

        Assert.assertEquals(6, PAPER.play(ROCK));
        Assert.assertEquals(3, PAPER.play(PAPER));
        Assert.assertEquals(0, PAPER.play(SCISSOR));

        Assert.assertEquals(0, SCISSOR.play(ROCK));
        Assert.assertEquals(6, SCISSOR.play(PAPER));
        Assert.assertEquals(3, SCISSOR.play(SCISSOR));

    }

    @Test
    public void testScore() {
        Assert.assertEquals(1, ROCK.score());
        Assert.assertEquals(2, PAPER.score());
        Assert.assertEquals(3, SCISSOR.score());
    }

    @Test
    public void testOutcomes() {
        Assert.assertEquals(4, ROCK.outcome(ROCK));
        Assert.assertEquals(2, PAPER.outcome(SCISSOR));
        Assert.assertEquals(9, SCISSOR.outcome(PAPER));
    }

}