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
            exch(a, i , j);
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


    public static void main(String[] args) {
        Character[] chrarray = new Character[]{'K', 'R', 'A', 'T', 'E', 'L', 'E', 'P', 'U', 'I', 'M', 'Q', 'C', 'X', 'O', 'S'};
        System.out.println(partition(chrarray, 0, chrarray.length - 1));
        System.out.println(Arrays.toString(chrarray));

        System.out.println("Quicksort implementation");
        Integer[] ia = new Integer[]{5, 1, 4, 2, 3, 3, 2, 4, 1, 5};
        sort(ia);

    }

}
