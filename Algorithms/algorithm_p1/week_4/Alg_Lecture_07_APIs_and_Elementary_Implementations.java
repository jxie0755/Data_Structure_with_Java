package algorithm_p1.week_4;

import java.util.Arrays;

public class Alg_Lecture_07_APIs_and_Elementary_Implementations {

    /*
     * Collections
        * Stack - Remove the item most recently added
        * Queue - Remove the item least recently added
        * Randomized queue - Remove a random item
        * Priority queue - Remove the largest (or smallest) item
            * Use Binary Heap (tree like) -- the best method
                * but use array to implement
                    * index 0 is max/min
                    * then children is always smaller/larger than parent
                    * finding parent index of children at index k is easy: k // 2
                    * finding left and right of a parent at k is easy: k*2 and k*2+1
                * Can be setup in two ways:
                    * Top is the largest (Max-oriented)
                    * Top is the smallest (Min-oriented)
                * Rest of the sequence follow the same rule, but it left and right does not matter
                * Exchange is needed to revise, push and pop values from the binary-heap
                    * repeat until heap order restored
     */

}


class BinaryHeap_maxOriented {

    // Initiation
    private Comparable[] heap;
    private int N;

    public BinaryHeap_maxOriented (Comparable[] a) {

        N = a.length;
        heap = this.heapify(a);
    }

    private Comparable[] heapify(Comparable[] a) {
        return a;
    }

    // Utility functions
    private void exch(int i, int j) {
        Comparable temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }

    private boolean less(int v, int w) {
        return this.heap[v].compareTo(this.heap[w]) < 0;
    }


    // Operation
    private void sink(int k) {
        // sink idx at k in a binary heap in the form of Comparable[]
        // Restore the order of the binary heap

        while (2 * k <= N-1) {
            int j = 2 * k;
            if (j < N && less(j, j + 1)) {
                j += 1;
            }
            if (!less(k, j)) {
                break;
            }
            exch(k, j);
            k = j;
        }

    }


    public static void main(String[] args) {

        BinaryHeap_maxOriented A = new BinaryHeap_maxOriented(new Character[]
                {
                        'Z', 'T', 'H', 'R', 'P', 'S', 'O', 'A', 'E', 'I', 'N', 'C'
                    //   0    1    2    3    4    5    6    7    8    9    10   11
                });

        A.sink(2);
        System.out.println(Arrays.toString(A.heap));
        // >>> [Z, T, S, R, P, N, O, A, E, I, H, C]  sinked H to index 10

    }




}
