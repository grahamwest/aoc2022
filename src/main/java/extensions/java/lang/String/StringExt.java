package extensions.java.lang.String;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.Set;

@Extension
public class StringExt {

    public static String[] chunk(@This String thiz, int chunkLength) {
        String[] chunks = new String[Math.ceilDiv(thiz.length(), chunkLength)];
        for (int i = 0; i < chunks.length; i++) {
            chunks[i] = thiz.substring(i*chunkLength, Math.min(thiz.length(), (i+1)*chunkLength));
        }
        return chunks;
    }

    public static String[] segment(@This String thiz, int numberOfSegments) {
        return thiz.chunk(Math.ceilDiv(thiz.length(), numberOfSegments));
    }

    public static Set<Integer> uniqueCodepoints(@This String thiz) {
        return thiz.codePoints().toSet();
    }
}
