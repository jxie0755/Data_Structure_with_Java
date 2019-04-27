package algorithm_p1.week_2;

import java.util.Arrays;

public class Alg_Lecture_04_elementary_sorts {

    /*
     * To sort a number of elements, first we need to be able to compare elements
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
        return v.compareTo(w) == -1;
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
        * Code omitted, too simple
        * start from first element a[i], iterate to the element a[j]
            * if a[j] > a[i], then keep iterating
            * if a[j] < a[i], then swap the two until the first j element is sorted
     *
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
        return v.compareTo(w) == -1;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(Comparable[] a) {

        int N = a.length;
        System.out.println("??");
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
        Integer[] intarray1 = new Integer[]{1, 4, 3, 6, 4, 8, 4, 7, 9, 3};
        InsertionSort.sort(intarray1);
        System.out.println(Arrays.toString(intarray1));
    }

}
