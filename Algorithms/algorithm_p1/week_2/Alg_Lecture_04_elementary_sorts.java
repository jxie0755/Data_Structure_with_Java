package algorithm_p1.week_2;

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
     *
     *
     *
     *
     *
     *
     *
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
        for (int i = h; i < N; i++) {
            for (int j = i; j > 0; j-=h) {
                if (j-h >= 0 && less(a[j], a[j-h])) {
                    exch(a, j, j-h);
                } else {
                    break;
                }
            }
        }
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

    }
}





