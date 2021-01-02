package com.sample.interview.hackerrank;

import java.util.Arrays;
import java.util.stream.Stream;

public class MergeArrays {
    public static void main(String[] args) {
        Integer[] a = {3, 25, 48, 16};
        Integer[] b = {23, 15, 11, 36};

//        Integer[] c = mergeWithArrayCopy(a, b);
//        Integer[] c = mergeWithArrayIteration(a, b);
        Integer[] c = mergeWithFlatMap(a, b);
//        Integer[] c = mergeWithConcat(a, b);
        Arrays.sort(c);
        System.out.println(Arrays.toString(c));
    }

    public static Integer[] mergeWithArrayCopy(Integer[] a, Integer[] b) {
        Integer[] r = new Integer[a.length + b.length];
        System.arraycopy(a, 0, r, 0, a.length);
        System.arraycopy(b, 0, r, a.length, b.length);
        return r;
    }

    public static Integer[] mergeWithArrayIteration(Integer[] a, Integer[] b) {
        Integer[] r = new Integer[a.length + b.length];
        for(Integer i=0; i<a.length; i++) {
            r[i] = a[i];
        }
        for(Integer i=0; i<b.length; i++) {
            r[a.length + i] = b[i];
        }
        return r;
    }

    public static Integer[] mergeWithFlatMap(Integer[] a, Integer[] b) {
        Object[] c = Stream.of(a, b).flatMap(Arrays::stream).toArray();
        Integer[] r = new Integer[c.length];
        for(Integer i=0; i<c.length; i++) {
            r[i] = (Integer) c[i];
        }
        return r;
    }

    public static Integer[] mergeWithConcat(Integer[] a, Integer[] b) {
        Object[] c = Stream.concat(Stream.of(a), Stream.of(b)).toArray();
        Integer[] r = new Integer[c.length];
        for(Integer i=0; i<c.length; i++) {
            r[i] = (Integer) c[i];
        }
        return r;
    }
}
