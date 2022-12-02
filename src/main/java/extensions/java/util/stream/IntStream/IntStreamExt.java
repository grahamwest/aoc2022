package extensions.java.util.stream.IntStream;

import manifold.ext.rt.api.Extension;
import manifold.ext.rt.api.This;

import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Extension
public class IntStreamExt {

    public static IntStream sortedDesc(@This IntStream thiz) {
        int[] sorted = thiz.sorted().toArray();

        for (int i = 0; i <= sorted.length/2; i++) {
            int tmp = sorted[sorted.length - i - 1];
            sorted[sorted.length - i - 1] = sorted[i];
            sorted[i] = tmp;
        }

        return IntStream.of(sorted);
    }

    public static IntStream top(@This IntStream thiz, int n) {
        return thiz.sortedDesc().limit(n);
    }

    public static Stream<IntStream> split(@This IntStream thiz, Predicate<Integer> isSeparator) {
        return thiz.boxed().split(isSeparator).map(x -> x.mapToInt(Integer::intValue));
    }

}
