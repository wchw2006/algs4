package edu.wcw;

import java.util.stream.IntStream;

import edu.princeton.cs.algs4.StdIn;

public class WShell implements WISort {

    @Override
    public void sort(Comparable[] a) {
        int n = a.length;
        int h = n / 3;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
                    exch(a, j, j - h);
                }
            }
            h = h / 3;
        }
    }
    public static void main(String[] args) {
        // String[] strs = StdIn.readAllStrings();
        int[] ints = StdIn.readAllInts();
        Integer[] a = new Integer[ints.length];
        IntStream.range(0, ints.length).forEach(index -> a[index] = ints[index]);
        // Arrays
        // IntStream.range(0, strs.length).forEach(i -> a[i] = Integer.valueOf(strs[i]));
        WISort sort = new WShell();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
    }
}
