package algorithm_p1.week_1;

public class Alg_Lecture_02_Complexity {
    /*
     * Tilde
        * leading term for a specific case of algorithm
        * Provide approximate model

     * These are more for analyzing the problem instead of analyzing the algorithm
     * Big Theta
        * describe the order of growth in the current case
        * asymptotic growth rate  ("expected" cost)
        * classify alogirthms
     * Big Oh
        * Theta(N^2) and smaller
        * develop upper bound (worst case)
     * Big omega
        * Theta(N^2) and larger
        * develop lower bound (best case)
     */


    /*
     * Analysis of algorithm: find 0 in array
        * Upper bound:
            * Brutal force - check every item in array O(N)
        * Lower bound:
            * You must check all the items to avoid bypassing Omega(N)
        * Optimal case:
            * Lower bound == Upper bound
            * Brutal force is already optimal
    * Analysis of algorithm: 3-sum
        * Upper bound:
            * improved algorithm @ O(N^2*LogN)
        * Lower bound:
            * You must check all the entries in the array: Omega(N)
        * Optimal case:
            * Questionable.
     */
}
