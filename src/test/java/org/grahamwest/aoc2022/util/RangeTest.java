package org.grahamwest.aoc2022.util;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangeTest {

    @Test
    public void overlaps() {

        Range oneToThree = Range.from("1-3");
        Range threeToSix = Range.from("3-6");
        Range fiveToSeven = Range.from("5-7");
        Range sevenToNine = Range.from("7-9");
        Range oneNine = Range.from("1-9");

        Assert.assertFalse(oneToThree.overlaps(fiveToSeven));
        Assert.assertFalse(sevenToNine.overlaps(oneToThree));
        Assert.assertTrue(oneToThree.overlaps(threeToSix));
        Assert.assertTrue(threeToSix.overlaps(fiveToSeven));
        Assert.assertTrue(fiveToSeven.overlaps(threeToSix));
        Assert.assertTrue(fiveToSeven.overlaps(sevenToNine));
        Assert.assertTrue(oneNine.overlaps(threeToSix));
        Assert.assertTrue(threeToSix.overlaps(oneNine));
    }
}