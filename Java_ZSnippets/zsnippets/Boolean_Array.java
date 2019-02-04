package zsnippets;// Learn some quick things about Boolean array

import java.util.Arrays;

public class Boolean_Array {
    public static void main(String[] args) {
        boolean[] b1 = new boolean[3];  // Initiation is always filled wilth false
        for (boolean i: b1) {
            System.out.println(i);
        }
        // >>>
        // false
        // false
        // false

        boolean[] b2 = new boolean[3];
        Arrays.fill(b2, true);
        for (boolean i: b2) {
            System.out.println(i);
        }
        // >>>
        // true
        // true
        // true

    }
}

