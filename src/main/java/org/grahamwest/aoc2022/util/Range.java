package org.grahamwest.aoc2022.util;

import java.util.Arrays;
import java.util.List;

public record Range<T extends Comparable>(T lowerBound, T upperBound) {

    private boolean lte(Comparable f, Comparable s) {
        return f.compareTo(s) <= 0;
    }

    private boolean gte(Comparable f, Comparable s) {
        return f.compareTo(s) >= 0;
    }

    public boolean contains(Range<T> subrange) {
        return lte(this.lowerBound, subrange.lowerBound()) && gte(this.upperBound, subrange.upperBound);
    }

    public boolean contains(T value) {
        return lte(this.lowerBound, value) && gte(this.upperBound, value);
    }

    public boolean overlaps(Range<T> subrange) {
        return contains(subrange.lowerBound()) || contains(subrange.upperBound()) || subrange.contains(lowerBound()) || subrange.contains(upperBound());
    }

    public static Range<Integer> from(String pattern) {
        List<Integer> bounds = Arrays.stream(pattern.split("-")).map(Integer::valueOf).toList();
        return new Range<>(Math.min(bounds.get(0), bounds.get(1)), Math.max(bounds.get(0), bounds.get(1)));
    }

}
