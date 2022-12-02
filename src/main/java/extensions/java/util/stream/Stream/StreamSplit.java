package extensions.java.util.stream.Stream;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Extension
public class StreamSplit {

    @Extension
    public static <T> Stream<Stream<T>> split(@This Stream<T> thiz, Predicate<T> isSeparator) {
        List<Stream<T>> substreams = new LinkedList<>();

        Stream.Builder<T> builder = Stream.builder();
        for (T el : thiz.toList()) {
            if (isSeparator.test(el)) {
                substreams.add(builder.build());
                builder = Stream.builder();
            } else {
                builder.add(el);
            }
        }
        substreams.add(builder.build());

        return substreams.stream();
    }

}
