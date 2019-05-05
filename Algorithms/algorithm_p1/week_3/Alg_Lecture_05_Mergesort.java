package algorithm_p1.week_3;

import java.util.Arrays;

public class Alg_Lecture_05_Mergesort {

    /*
     * Two classic sorting algorithms
        * Mergesort
            * Divide array into two halves
            * Recursively sort each half
            * Merge two halves

        * Quicksort
            * Honored as one of the top 10 algorithm of 20th centry in science and engineering.
     */

}


class Alg_Mergesort {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static boolean isSorted(Comparable[] a, int start, int end) {
        for (int i = start + 1; i <= end; i += 1) {
            Comparable pre = a[i-1];
            Comparable cur = a[i];
            if (pre.compareTo(cur) > 0) {
                return false;
            }
        }
        return true;
    }

    // Must assert first half (lo to mid) and second half (mid to hi) are both sorted
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        assert isSorted(a, lo, mid);
        assert isSorted(a, mid+1, hi);

        // Copy everything to aux
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }

        // Merge the two sorted sub-array
        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {

            if (i > mid) {
                a[k] = aux[j];
                j += 1;
            } else if (j > hi) {
                a[k] = aux[i];
                i += 1;
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j];
                j += 1;
            } else {
                a[k] = aux[i];
                i += 1;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        merge(a, new Integer[a.length], 0, 4, 9);
        System.out.println(Arrays.toString(a));
    }
}
