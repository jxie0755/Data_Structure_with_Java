package algorithm_p1.week_1;

import java.util.Arrays;

public class Alg_lecture_01_UnionFind {

}

// We introduce the union–find data type and consider several implementations
// for solving the so-called dynamic connectivity problem:
// quick find
// quick union
// weighted quick union
// and weighted quick union with path compression
// Finally, we apply the union–find data type to the percolation problem from physical chemistry.


// give a set of objects, to tell if two of them is connected or not.


// algor_QuickFindUF
// use Array, and use index to label the objects, and the value to id the group
// therefore the two index had the same value, is connected
class algor_QuickFindUF {
    /*
     * Complexity
     * initialize - O(N)
     * union - O(N)
     * find - O(1)
     * too slow for huge problem
     */

    private int[] id;

    public algor_QuickFindUF(int N) {
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
        algor_QuickFindUF Q1 = new algor_QuickFindUF(10);
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


// algor_QuickUnionUF
// Use same array id[], as a tree type
// each index's value is the index of its parent index
class algor_QuickUnionUF {

    /*
     * Complexity
     * initialize - O(N)
     * union - O(N)
     * find - O(N)   trees can get tall
     */

    private int[] id;

    public algor_QuickUnionUF(int N) {
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
        algor_QuickUnionUF Q2 = new algor_QuickUnionUF(10);
        Q2.union(4, 3);
        Q2.union(3, 8);
        Q2.union(6, 5);
        Q2.union(9, 4);
        Q2.union(2, 1);
        Q2.union(5, 0);
        Q2.union(7, 2);
        Q2.union(6, 1);
        Q2.union(7, 3);
        System.out.println(Arrays.toString(Q2.id));
        // [1, 8, 1, 8, 3, 0, 5, 1, 8, 8]
    }

}


// Quick Union improvement
// improvement 1: weighting
// avoid putting taller tree as a sub-tree of a shorter tree, but do the opposite
class algor_QuickUnionUF_weighted {

    /*
     * Complexity
     * initialize - O(N)
     * union - O(lg(N))
     * find - O(lg(N))   trees can get tall
     */

    private int[] id;

    private int[] sz; // add an array to record the size of tree of each element
    // 注意这里记录的size是以这个节点为root的size,所以变化root的size,不是root的话,就不会被查到
    // 注意size是nodes的总数而不是tree的height

    private int[] mx;

    public algor_QuickUnionUF_weighted(int N) {
        id = new int[N];
        for (int i = 0; i < N; i += 1) {
            id[i] = i;
        }

        // construct the initial size to be 1
        sz = new int[N];
        for (int i = 0; i < N; i += 1) {
            sz[i] = 1;
        }

        mx = new int[N];
        for (int i = 0; i < N; i += 1) {
            mx[i] = i;
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
            if (sz[q] <= sz[p]) {
                id[rt_q] = rt_p;
                sz[rt_p] += sz[rt_q];  // 改变这个root的size
                if (mx[rt_q] > mx[rt_p]) {
                    mx[rt_p] = mx[rt_q];
                }
            } else {
                id[rt_p] = rt_q;
                sz[rt_q] += sz[rt_p];  // 改变这个root的size
                if (mx[rt_p] > mx[rt_q]) {
                    mx[rt_q] = mx[rt_p];
                }
            }
        }
    }

    // Quiz
    // Union-find with specific canonical element.
    // Add a method find() to the union-find data type so that find(i) returns the largest element in the connected component containing ii.
    // The operations, union(), connected(), and find() should all take logarithmic time or better.
    // if a union is {1,2,6,9}, then find(1) == find(2) == find(6) == find(9) == 9
    public int find(int p) {
        return mx[this.root(p)];
    }


    public static void main(String[] args) {
        algor_QuickUnionUF_weighted Q3 = new algor_QuickUnionUF_weighted(10);

        Q3.union(4, 3);
        Q3.union(3, 8);
        Q3.union(6, 5);
        Q3.union(9, 4);
        Q3.union(2, 1);
        Q3.union(5, 0);
        Q3.union(7, 2);
        Q3.union(6, 1);
        // System.out.println(Arrays.toString(Q3.id));
        // [6, 2, 6, 4, 4, 6, 6, 2, 4, 4]

        System.out.println("test quiz find");
        assert Q3.find(1) == 7;
        System.out.println("quiz passed");

        Q3.union(7, 3);
        // System.out.println(Arrays.toString(Q3.id));
        // [6, 2, 6, 4, 6, 6, 6, 2, 4, 4]
    }

}

// Further improvement: Path compression
class algor_QuickUnionUF_weighted_path_compressed {

    /*
     * Complexity
     * initialize - O(N)
     * union - O(lg*(N))
     * find - O(lg*(N))
     */

    private int[] id;
    private int[] sz;

    public algor_QuickUnionUF_weighted_path_compressed(int N) {
        id = new int[N];
        for (int i = 0; i < N; i += 1) {
            id[i] = i;
        }

        sz = new int[N];
        for (int i = 0; i < N; i += 1) {
            sz[i] = 1;
        }
    }

    public int root(int p) {
        while (id[p] != p) {
            id[p] = id[id[p]];  // add one line: make every node in path point to its grandparent
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
            if (sz[q] <= sz[p]) {
                id[rt_q] = rt_p;
                sz[rt_p] += sz[rt_q];  // 改变这个root的size
            } else {
                id[rt_p] = rt_q;
                sz[rt_q] += sz[rt_p];  // 改变这个root的size
            }
        }
    }


    public static void main(String[] args) {
        algor_QuickUnionUF_weighted_path_compressed Q4 = new algor_QuickUnionUF_weighted_path_compressed(10);
        Q4.union(4, 3);
        Q4.union(3, 8);
        Q4.union(6, 5);
        Q4.union(9, 4);
        Q4.union(2, 1);
        Q4.union(5, 0);
        Q4.union(7, 2);
        Q4.union(6, 1);
        System.out.println(Arrays.toString(Q4.id));
        // [6, 2, 6, 4, 4, 6, 6, 2, 4, 4]
        Q4.union(7, 3);
        System.out.println(Arrays.toString(Q4.id));
        // [6, 2, 6, 4, 6, 6, 6, 6, 4, 4]
    }

}


