package algorithm_p1.week_1.percolation;

import java.util.Arrays;

public class Percolation {
    int total_n;
    int size;

    int[] id;
    int[] status;
    int[] sz;


    // create n-by-n grid, with all sites blocked
    public Percolation(int n) {
        this.size = n;
        this.total_n = n * n + 2;

        this.id = new int[this.total_n];   // inlcude virtual top open and bottom open sites

        for (int i = 0; i <= this.total_n - 1; i++) {
            this.id[i] = i;
        }

        for (int i = 1; i <= n; i++) {
            this.id[i] = 0;
        }

        for (int i = n*(n-1); i <= n*n; i++) {
            this.id[i] = 26;
        }

        this.status = new int[this.total_n];
        status[0] = 1;            // top virtual open
        status[n * n + 1] = 1;    // bottom virtual open

        this.sz = new int[this.total_n];
        for (int i = 0; i <= this.total_n - 1; i += 1) {
            this.sz[i] = 1;
        }
        this.sz[0] = 1 + this.size;
        this.sz[n * n + 1] = 1 + this.size;


    }


    // implementation of UF
    public int translateCoor(int row, int col) {
        return row * this.size + col + 1;
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
            } else{
                id[rt_p] = rt_q;
                sz[rt_q] += sz[rt_p];  // 改变这个root的size
            }
        }
    }

    // open site (row, col) if it is not open already
    public void open(int row, int col) {
        int idx = this.translateCoor(row, col);
        this.status[idx] = 1;

        // try to connect with the 4 neighbors


    }

    // is site (row, col) open?
    public boolean isOpen(int row, int col) {
        int idx = this.translateCoor(row, col);
        return this.status[idx] == 1;
    }

    // is site (row, col) full?
    // public boolean isFull(int row, int col)

    // number of open sites
    // public int numberOfOpenSites()

    // does the system percolate?
    // public boolean percolates()

    // test client (optional)
    public static void main(String[] args) {
        Percolation T1 = new Percolation(5);
        System.out.println(Arrays.toString(T1.id));
        System.out.println(Arrays.toString(T1.status));
        System.out.println(Arrays.toString(T1.sz));

    }
}
