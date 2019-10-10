/**
 * https://leetcode.com/problems/unique-paths/
 * P062 Unique Paths
 * Medium
 * <p>
 * A robot is located at the top-left corner of a m x n grid (marked "Start" in the diagram below).
 * <p>
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked "Finish" in the diagram below).
 * <p>
 * How many possible unique paths are there?
 */
public class LC062_Unique_Path {

    /**
     * Version A, best direct math calculation
     * This is the same as ProjectEuler p015 lattice paths
     * Use combination method: Combination pick r out of n : n! // r! // (n-r)!
     * 注意这里要处理大数问题, 阶乘数大了之后, 溢出了int和long的范围
     */
    public int uniquePaths(int m, int n) {
        int total = m + n - 2;
        long result = factorial(total) / (factorial(total - (n - 1)) * factorial(n - 1));
        return (int) result;
    }

    /**
     * Helper: factorial calculation
     */
    private long factorial(int x) {
        if (x == 0) {
            return 1;
        } else {
            return x * factorial(x - 1);
        }
    }


    public static void main(String[] args) {
        assert new LC062_Unique_Path().uniquePaths(1, 1) == 1 : "Edge 1";
        assert new LC062_Unique_Path().uniquePaths(4, 1) == 1 : "Edge 2";
        assert new LC062_Unique_Path().uniquePaths(1, 4) == 1 : "Edge 3";

        assert new LC062_Unique_Path().uniquePaths(3, 2) == 3 : "Example 1";
        assert new LC062_Unique_Path().uniquePaths(7, 3) == 28 : "Example 2";
        assert new LC062_Unique_Path().uniquePaths(10, 10) == 48620 : "Example 3";
        System.out.println("all passed");
    }

}

