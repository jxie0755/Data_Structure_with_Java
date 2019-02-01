package java_reference_chapter_01;

import java.util.Arrays;  // Array并不是列表

public class C11_Arrays {

    // Practice of finding primes with The Sieve of Eratosthenes
    /** Returns an array, p, of size N+1 such that p[k] is true iff
      * k is a prime. */
    public static boolean[] primes (int n) {
        boolean[] prime_sieve = new boolean[n + 1];  // a list of boolean length at n+1, initialized list will be all false!
        // All entries are initially true.
        Arrays.fill(prime_sieve, true);
        prime_sieve[0] = prime_sieve[1] = false;
        for (int k = 2; k * k <= n; k += 1) {
            for (int j = k * k; j <= n; j += k) {
                prime_sieve[j] = false;
            }
        }
        return prime_sieve;
    }

    public static void main(String[] args) {
        int[] A;
        // System.out.println(A);  Not initialized, only created a null point (linked list)
        A = new int[]{1, 2, 3};
        System.out.println(A);  // >>> [I@1e643faf   // Does not print out A
        System.out.println(A.length);  // >>> 3

        A = new int[100];  // this create a new int list of length at 100
        System.out.println(A.length);  // >>> 100

        boolean[] S = primes(20);
        int i = 0;
        while (i != S.length) {
            if (S[i]) {
                System.out.println(i);
            }
            i += 1;
        }
        // >>>
        // 2
        // 3
        // 5
        // 7
        // 11
        // 13
        // 17
        // 19


    }



}

