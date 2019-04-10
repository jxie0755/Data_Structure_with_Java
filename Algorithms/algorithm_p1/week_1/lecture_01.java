package algorithm_p1.week_1;

import java.util.Arrays;

public class lecture_01 {

}

// We introduce the union–find data type and consider several implementations
// for solving the so-called dynamic connectivity problem:
    // quick find
    // quick union
    // weighted quick union
    // and weighted quick union with path compression
// Finally, we apply the union–find data type to the percolation problem from physical chemistry.



// give a set of objects, to tell if two of them is connected or not.


// QuickFindUF
// use Array, and use index to label the objects, and the value to id the group
// therefore the two index had the same value, is connected
class QuickFindUF {
    /*
     * Complexity
         * initialize - O(N)
         * union - O(N)
         * find - O(1)
         * too slow for huge problem
     */

    private int[] id;

    public QuickFindUF (int N){
        id = new int[N];
        for (int i = 0; i < N; i += 1) {
            id[i] = i;
        }
    }

    // takes 1 step
    public boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    // takes N steps
    public void union(int p, int q) {
        int q_val = id[q];
        int p_val = id[p];
        if (q_val != p_val) {
            for (int i = 0; i < this.id.length; i += 1) {
                if (id[i] == p_val) {
                    id[i] = q_val;
                }
            }
        }
    }

    public static void main(String[] args) {
        QuickFindUF Q1 = new QuickFindUF(10);
        Q1.union(1, 2);
        Q1.union(3, 4);
        Q1.union(0, 5);
        Q1.union(3, 8);
        Q1.union(2, 7);
        Q1.union(9, 4);
        Q1.union(5, 6);
        System.out.println(Arrays.toString(Q1.id));
        // >>> [6, 7, 7, 8, 8, 6, 6, 7, 8, 8]
    }

}


// QuickUnionUF
// Use same array id[], as a tree type
// each index's value is the index of its parent index
class QuickUnionUF {

    /*
     * Complexity
         * initialize - O(N)
         * union - O(N)
         * find - O(N)   trees can get tall
     */

    private int[] id;

    public QuickUnionUF (int N){
        id = new int[N];
        for (int i = 0; i < N; i += 1) {
            id[i] = i;
        }
    }

    public int root(int p) {
        while (id[p] != p) {
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return this.root(p) == this.root(q);
    }

    public void union(int p, int q) {
        int rt_p = this.root(p);
        int rt_q = this.root(q);
        if (rt_p != rt_q) {
            id[rt_p] = rt_q;
        }

    }


    public static void main(String[] args) {
        QuickUnionUF Q2 = new QuickUnionUF(10);
        Q2.union(4, 3);
        Q2.union(3, 8);
        Q2.union(6, 5);
        Q2.union(9, 4);
        Q2.union(2, 1);
        Q2.union(5, 0);
        Q2.union(7, 2);
        Q2.union(6, 1);
        Q2.union(7, 3);
        System.out.println(Q2.root(4));
        System.out.println(Arrays.toString(Q2.id));
    }

}

