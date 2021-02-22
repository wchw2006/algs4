package edu.wcw;

import java.util.stream.IntStream;

import edu.princeton.cs.algs4.StdIn;

public class WMerge implements WISort {

    private Comparable[] aux;

    @Override
    public void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++)
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[j], aux[i]))
                a[k] = aux[j++];
            else
                a[k] = aux[i++];

    }
    /**
     * java edu.wcw.WMerge < ../../algs4-data/word.txt
     * @param args
     */
    public static void main(String[] args) {
        // String[] strs = StdIn.readAllStrings();
//        int[] ints = StdIn.readAllInts();
        int[] ints = {10,1,12,5,3,4};
        Integer[] a = new Integer[ints.length];
        IntStream.range(0, ints.length).forEach(index -> a[index] = ints[index]);
        // Arrays
        // IntStream.range(0, strs.length).forEach(i -> a[i] = Integer.valueOf(strs[i]));
        WISort sort = new WMerge();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
    }
}
