package algorithm_p1.week_3;


import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Alg_Lecture_06_Quicksort {

    /*
     * Quicksort
     * Most important sorting in 20th century
     * Also a recursive method
     * Basic plan
     * shuffle the array
     * Partition so that, for some j:
     * entry a[j] is in place
     * no larger entry to the left of j
     * no smaller entry to the right of j
     * sort each piece recursively
     */


    /*
     * Selection
     * Goal: Given an array of N items, find the kth largest.
     * Example:
     * min: (k=0)
     * max: (k=N-1)
     * median: (k=N/2)
     * Applications
     * Order statistics
     * Find the "top k."
     * Quick-select
     * Similar idea as Quicksort
     * Partition first
     * Divided into two sub-array and recursively run
     * Takes linear time on average
     * Quadratic in worst case but shuffle will help to avoid
     */


    /*
     * Duplicate Keys
     * Often, purpose of sort is to bring items with equal keys together
     * Sort population by age
     * Find collinear points
     * Remove duplicates from mailing list
     * Sort job applicats by college attended
     * Typical characteristics of such applications
     * Huge array
     * Small number of key values
     * sorting algorithms
     * Mergesort does not care, always use NlogN
     * Quicksort goes quadratics unless partitions stops on equal keys
     * Method: do 3 way partitioning, put all identical items in the middle
     */
}


class Alg_Quicksort {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    // This is the key part and the trickiest part
    private static int partition(Comparable[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        Comparable keyelem = a[lo];

        while (true) {

            while (less(a[++i], a[lo])) {
                if (i == hi) {
                    break;
                }
                // this if condition is a must
            }

            while (less(a[lo], a[--j])) {
                if (j == lo) {
                    break;
                }
                // this if condition could be redundant
            }

            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;
    }


    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi > lo) {
            int j = partition(a, lo, hi);
            System.out.println("lo: " + lo + " hi: " + hi + " j: " + j);
            System.out.println(Arrays.toString(a));
            sort(a, lo, j - 1);
            sort(a, j + 1, hi);
        }

    }

    // Overload for direct use
    public static void sort(Comparable[] a) {
        StdRandom.shuffle(a);  // this shuffle is needed for performance guarantee
        System.out.println("After shuffle: ");
        System.out.println(Arrays.toString(a));
        sort(a, 0, a.length - 1);
    }


    // Selection: Quick-select, similar idea as Quicksort
    public static Comparable select(Comparable[] a, int k) {

        // Same reason to shuffle for performance guarantee
        StdRandom.shuffle(a);

        int lo = 0;
        int hi = a.length - 1;
        while (hi > lo) {
            int j = partition(a, lo, hi);
            if (j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                return a[k];
            }
        }
        return a[k];
    }


    // 3-way quicksort, solve duplicated key problem
    // This is not just faster, but also use simpler codes
    private static void three_way_quicksort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }

        // partitioning is directly incorporated into the sort process
        int lt = lo;
        int gt = hi;
        Comparable v = a[lt];

        int i = lt;
        while (i <= gt) {
            int cmp = a[i].compareTo(v);
            if (cmp < 0) {
                exch(a, lt, i);
                lt += 1;
                i += 1;
            } else if (cmp > 0) {
                exch(a, i, gt);
                gt -= 1;
            } else {
                i += 1;
            }
        }

        three_way_quicksort(a, lo, lt - 1);
        three_way_quicksort(a, gt + 1, hi);
    }

    private static void three_way_quicksort(Comparable[] a) {
        // can still use shuffle to improve partitioning method
        StdRandom.shuffle(a);

        three_way_quicksort(a, 0, a.length - 1);
    }


    public static void main(String[] args) {
        Character[] chrarray = new Character[]{
                'K', 'R', 'A', 'T', 'E', 'L', 'E', 'P', 'U', 'I', 'M', 'Q', 'C', 'X', 'O', 'S'
        };
        System.out.println(Alg_Quicksort.partition(chrarray, 0, chrarray.length - 1));
        System.out.println(Arrays.toString(chrarray));

        System.out.println("Quicksort implementation");
        Integer[] ia = new Integer[]{5, 1, 4, 2, 3, 3, 2, 4, 1, 5};
        Alg_Quicksort.sort(ia);

        Integer[] ia2 = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(Alg_Quicksort.select(ia2, 0)); // >>> 0
        System.out.println(Alg_Quicksort.select(ia2, 7)); // >>> 7
        System.out.println(Alg_Quicksort.select(ia2, 2)); // >>> 2

        // Test 3-way quicksort
        System.out.println("Test 3-way quicksort");
        Integer[] ia3 = new Integer[]{1, 9, 7, 3, 5, 5, 3, 7, 9, 1};
        three_way_quicksort(ia3);
        System.out.println(Arrays.toString(ia3));
    }
}







