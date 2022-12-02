package extensions.java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamSplitTest {

    @Test
    public void testStreamSplitWords() {

        Stream<String> paragraph = Stream.of("The", "quick", "brown", "fox", ".", "How", "much", "wood");
        Stream<Stream<String>> sentences = paragraph.split( w -> w.equals("."));
        String words = sentences.map(sentence -> sentence.collect(Collectors.joining(" ")))
                .collect(Collectors.joining(". "));

        Assert.assertEquals("The quick brown fox. How much wood", words);
    }

    @Test
    public void testStreamInts() {

        Stream<OptionalInt> nums = Stream.of(OptionalInt.of(1), OptionalInt.of(2), OptionalInt.empty(), OptionalInt.of(5), OptionalInt.of(6));
        Stream<Stream<OptionalInt>> splitNums = nums.split(OptionalInt::isEmpty);
        String words = splitNums.map(sentence -> sentence.collect(Collectors.summingInt(OptionalInt::getAsInt)) + "" )
                .collect(Collectors.joining("."));

        Assert.assertEquals("3.11", words);
    }

}