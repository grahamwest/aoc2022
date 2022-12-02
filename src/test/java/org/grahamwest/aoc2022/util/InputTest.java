package org.grahamwest.aoc2022.util;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

public class InputTest {

    @Test
    public void testReadingLines() {
        Stream<String> lines = Input.asStrings(0);

        List<String> list = lines.toList();
        Assert.assertEquals(2, list.size());
        Assert.assertEquals("hello", list.get(0));
        Assert.assertEquals("world", list.get(1));
    }

}
