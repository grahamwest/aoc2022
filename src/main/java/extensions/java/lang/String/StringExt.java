package extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.Set;
import java.util.stream.Stream;

@Extension
public class StringExt {

    public static Stream<String> chunk(@This String thiz, int chunkLength) {
        int numChunks = Math.ceilDiv(thiz.length(), chunkLength);

        Stream.Builder<String> chunks = Stream.builder();
        for (int i = 0; i < numChunks; i++) {
            chunks.add(thiz.substring(i*chunkLength, Math.min(thiz.length(), (i+1)*chunkLength)));
        }
        return chunks.build();
    }

    public static Stream<String> segment(@This String thiz, int numberOfSegments) {
        return thiz.chunk(Math.ceilDiv(thiz.length(), numberOfSegments));
    }

    public static Set<Integer> uniqueCodepoints(@This String thiz) {
        return thiz.codePoints().toSet();
    }
}
