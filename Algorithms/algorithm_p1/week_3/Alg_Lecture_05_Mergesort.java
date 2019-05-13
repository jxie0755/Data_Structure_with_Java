package algorithm_p1.week_3;

import edu.princeton.cs.algs4.Insertion;

import java.util.Arrays;

public class Alg_Lecture_05_Mergesort {

    /*
     * Two classic sorting algorithms
        * Mergesort (Lecture 05)
            * Divide array into two halves
            * Recursively sort each half
            * Merge two halves

            * Two much overhead for tiny subarrays
            * Cutoff to insertion sort for = 7 items
                * During mergesort, when subarray less than 7,
                * Use insertion sort to excute the sort instead of merge sort

         * Quicksort (Lecture 06)
            * Honored as one of the top 10 algorithm of 20th centry in science and engineering.

     * Comparator
         * Refer to Java_101/W3C_Java_Classes/A11_Comparator.java

     * Stability
         * retain sort sequence in sections when sort by different way
            * for example:
                * student sorted by names first, then sorted by scores
                * but the students who shares the same scores, will still sorted by names
            * Insertion sort and Mergesort are stable
                * Mergesort: depends on the merge section
                    * if two items are equal, always take the left item -- then it is stable
            * Selection sort ans Shellsort are not stable
        * The key is not to move the equal value sequence pass each other

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


    // Recursive version
    private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {

        // Original: all the way to the 1 element subarray and merge back
        // if (hi <= lo) {
        //     return;
        // }

        // Improvement 1: Add InsertionSort when subarry is shorter than 7
        int CUTOFF = 7;
        if (hi <= lo + CUTOFF - 1) {
            Insertion.sort(a, lo, hi+1);
            return;
        }

        int mid = lo + (hi - lo) / 2;
        // recursively divide into smaller arrays
        System.out.println(lo + " " + mid + " " + hi);
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);

        // then recursively merge back
        // Improvement 2: if two subarray is naturally sorted by direction link, then skip the merge:
        if (!less(a[mid + 1], a[mid])) {
            return;
        }
        merge(a, aux, lo, mid, hi);
    }

    // Overload for direct use (Recursive version)
    private static void sort(Comparable[] a) {
        sort(a, new Comparable[a.length], 0, a.length - 1);
    }


    /*
     * Bottom-up Mergesort (no recursion version)
        * break down into 1 unit sub-array
        * then merge into one array by turn
     */
    public static void bottomupsort(Comparable[] a) {
        int N = a.length;
        Comparable[] aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) {
            for (int lo = 0; lo < N - sz; lo += sz + sz) {
                merge(a, aux, lo, lo + sz - 1, Math.min(lo + sz + sz - 1, N - 1));
                                                    // avoid idx exceed at the end
            }
        }
    }



    public static void main(String[] args) {
        Integer[] a = new Integer[]{1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
        merge(a, new Integer[a.length], 0, 4, 9);
        System.out.println(Arrays.toString(a));

        Integer[] b = new Integer[]{10, 2, 9, 7, 4, 3, 8, 6, 5, 1};
        sort(b);
        System.out.println(Arrays.toString(b));

        // Example of InsertionSort sort method:
        Integer[] c = new Integer[]{10, 2, 9, 7, 4, 3, 8, 6, 5, 1};
        Insertion.sort(c, 0, 3);
        System.out.println(Arrays.toString(c));
        // [2, 9, 10, 7, 4, 3, 8, 6, 5, 1]  (index 3 is not included)


        // Example of bottom up sort
        Integer[] d = new Integer[]{10, 2, 9, 7, 4, 3, 8, 6, 5, 1};
        Alg_Mergesort.bottomupsort(d);
        System.out.println(Arrays.toString(d));
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

    }
}
