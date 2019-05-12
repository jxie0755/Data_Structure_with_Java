package algorithm_p1.week_2;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Alg_Lecture_04_elementary_sorts {

    /*
     * To h_sort a number of elements, first we need to be able to compare elements
     * The object type must be implementing the interface Comparable<Item>
     * Following the natural total order rule
        * Antisymmetry: if v <= w and v >= w then v == w
        * Transitivity: if v <= w and w <= x then v <= x
        * Totality:     either v <= w or v >= w or both
     * Use compareTo method to compare v and w
     * v.compareTo(w)
        * v < w return -1
        * v == w return 0
        * v > w return 1
     */


    /*
     * two quick useful sorting abstraction
        * Less (return True if a < b else False)
        * Exchange (swap the value of a and b)
     */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    /*

     * Selection Sort
        * Code omitted, too simple
        * iterate and find the smallest value and swap to the first entry
        * Then continue to do the same thing to remaining array
        * O(N^2/2) always, regardless how the array is sorted
        *

     * Insertion Sort
        * start from first element a[i], iterate to the element a[j]
            * if a[j] > a[i], then keep iterating
            * if a[j] < a[i], then swap the two until the first j element is sorted
        * O(N^2/4), slightly better than Selection Sort
        * Best case: already sorted: O(N-1)
        * Worst case: O(N^2/2) iteration, O(N^2/2) swaps, slower than Selection

     * Shellsort
        * Move entries more than one position at a time by h-sorting the array
        * h-sorting is h interleaved sorted subsequences
            * L E E A M H L E P S O L T S X R    (h = 4)
            * L       M       P       T
            *   E       H       S       S
            *     E       L       O       X
            *       A       E       L       R
        * The code is almost the same as Insertion h_sort, except:
            * it goes h steps back, instead of 1 step back when exchanging
        * Why?
            * To prepare the array to become partially sorted,
            * so that insertion h_sort will be a lot quicker.
        * Useful in practice
            * Fast unless array size is huge
            * Tiny, fixed footprint for code (used in embedded systems)
            * Hardware sort prototype
            * Best sequence of increment is still unknown

     * Shuflle sort
        * How it's done
            * An array of Integer elements (Ai)
            * generate a random real number array (Ar) of an array (same length)
            * Each i is a key to value r.
            * Sort the (Ar) then move the key along, so that Ai is randomly shuffled
        * Provide a uniformly random permutation of the input array, provided no duplicate values
        * This needs to sort everytime, which cost a lot of resource
        * Do we have a better way to uniformly random permutate in a linear time?

        * Knuth shuffle
            * Linear time shuffling
            * In iteration i, pick interger r between 0 and i uniformly at random
            * Swap a[i] and a[r]

     */

}


class DateCompareExample implements Comparable<DateCompareExample> {

    // An example of how to create a user-defined comparable data type
    private final int month, day, year;

    public DateCompareExample(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
    }

    public int compareTo(DateCompareExample that) {
        if (this.year < that.year) {
            return -1;
        }
        if (this.year > that.year) {
            return 1;
        }
        if (this.month < that.month) {
            return -1;
        }
        if (this.month > that.month) {
            return 1;
        }
        if (this.day < that.day) {
            return -1;
        }
        if (this.day > that.day) {
            return 1;
        }
        return 0;
    }
}



// Selection Sort (code skipped)

// Insertion Sort
class InsertionSort {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(Comparable[] a) {

        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0; j--) {
                if (less(a[j], a[j-1])) {
                    exch(a, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] intarray1 = new Integer[]{1, 4, 3, 6, 5, 8, 2, 7, 9, 3};
        InsertionSort.sort(intarray1);
        System.out.println(Arrays.toString(intarray1));
        // >>> [1, 2, 3, 3, 4, 5, 6, 7, 8, 9]
    }
}


// Shellsort
class ShellSort {

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void h_sort(Comparable[] a, int h) {

        int N = a.length;
        for (int i = h; i < N; i++) {   // starting from index h
            for (int j = i; j > 0; j-=h) {
                if (j-h >= 0 && less(a[j], a[j-h])) {  // j jump back in h_steps
                    exch(a, j, j-h);
                } else {
                    break;
                }
            }
        }
    }

    public static void sort(Comparable[] a) {
        /**
         * apply with 3x + 1 h-sort
         */

        int h = 1;
        while (h + 3 <= a.length) {
            h += 3;
        }  // get the max h that is smaller than the array length

        while (h >= 1) {
            ShellSort.h_sort(a, h);
            h -= 3;
        } // use a while loop the h-sort the array and decrease the h until it becomes 1
    }

    public static void main(String[] args) {
        String[] strarray1 = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        System.out.println(Arrays.toString(strarray1));
        ShellSort.h_sort(strarray1, 7);
        System.out.println(Arrays.toString(strarray1));
        ShellSort.h_sort(strarray1, 3);
        System.out.println(Arrays.toString(strarray1));
        ShellSort.h_sort(strarray1, 1);
        System.out.println(Arrays.toString(strarray1));
        // >>>
        // [S, O, R, T, E, X, A, M, P, L, E]
        // [M, O, L, E, E, X, A, S, P, R, T]
        // [A, E, L, E, O, P, M, S, X, R, T]
        // [A, E, E, L, M, O, P, R, S, T, X]

        String[] strarray2 = new String[]{"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        ShellSort.sort(strarray2);
        System.out.println(Arrays.toString(strarray2));
    }
}

// Knuth Shuffle
class KnuthShuffle {

    private static void exch(Object[] a, int i, int j) {  // No longer need to be Comparable
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void shuffle(Object[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = StdRandom.uniform(i + 1); // return a random integer in [0:i)
            exch(a, i, r);
        }
    }

    /**
     * Suppose card index is 1 to 52 instead of 0 to 51
     */
    public static void shufflecards(Object[] a) {

        for (int i = 1; i <= 52; i++) {
            int r = StdRandom.uniform(51) + 1; // between 0+1 and 50+1 - 1 to 51
            exch(a, i, r);
        }
        /*
         * bug 1:
            * Random number r will never be 52, so card[52] can't endup in 52nd place
            * becaseu it will always be swapped with a card before it.
         * bug 2:
            * Shuffle not uniform (should be between 1 and i)
         * bug 3:
            * random() uses 32-bit seed only has 2^32 possible shuffles
            * 52! is the total swap number, it is bigger than 2^32
         * bug 4:
            * Seed = milliseconds since midnight 86.4 million shuffles
         * Exploit: After seeing 5 cards and synchronizing with server clock, it can determine all future cards in real time.
         */
    }

    public static void main(String[] args) {
        String[] strarray3 = new String[]{"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"};
        KnuthShuffle.shuffle(strarray3);
        System.out.println(Arrays.toString(strarray3));
    }
}



/*
 * Convex Hull problem
    * Convex Hull is the small convex that contains all the coordinates
    * There are points on the corner or on the oundary. Only on the corner is true convex
    * Out put sequence of vertices in counterclockwise order
 */
