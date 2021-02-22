package edu.wcw;

import java.util.stream.IntStream;

import edu.princeton.cs.algs4.StdIn;

public class WSentinelInsertion implements WISort {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int min = 0;
        for (int i = 1; i < N; i++) {
            if (less(a[i], a[min]))
                min = i;
        }
        exch(a, 0, min);
        for (int i = 1; i < N; i++) {
            for (int j = i; less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        // String[] strs = StdIn.readAllStrings();
        int[] ints = StdIn.readAllInts();
        Integer[] a = new Integer[ints.length];
        IntStream.range(0, ints.length).forEach(index -> a[index] = ints[index]);
        // Arrays
        // IntStream.range(0, strs.length).forEach(i -> a[i] = Integer.valueOf(strs[i]));
        WISort sort = new WSentinelInsertion();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
    }

}
