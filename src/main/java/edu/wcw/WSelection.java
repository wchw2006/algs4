package edu.wcw;

import java.util.stream.IntStream;

import edu.princeton.cs.algs4.StdIn;

public class WSelection implements WISort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exch(a, i, min);
        }
    }

    public static void main(String[] args) {
        // String[] strs = StdIn.readAllStrings();
        int[] ints = StdIn.readAllInts();
        Integer[] a = new Integer[ints.length];
        IntStream.range(0, ints.length).forEach(index -> a[index] = ints[index]);
        // Arrays
        // IntStream.range(0, strs.length).forEach(i -> a[i] = Integer.valueOf(strs[i]));
        WISort sort = new WSelection();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
    }

}
