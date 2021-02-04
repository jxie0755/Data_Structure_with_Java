import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/unique-binary-search-trees/
 * P096 Unique Binary Search Trees
 * Medium
 * <p>
 * Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?
 */
public class LC096_Unique_Binary_Search_Trees {
    /**
     * Version A3, Memorization method, use inner class setup
     */
    public int numTrees(int n) {

        Map<Integer, Integer> hmp = new HashMap<>(Map.ofEntries(
                Map.entry(0, 1),
                Map.entry(1, 1)
        ));


        /**
         * Inner class helper for memorization
         */
        class Helper {
            private int numTreesHelper(int n) {
                if (hmp.containsKey(n)) {
                    return hmp.get(n);
                } else {
                    int result = 0;
                    for (int rt = 1; rt <= n; rt += 1) {
                        int prev = rt - 1;
                        int after = n - rt;
                        result += this.numTreesHelper(prev) * this.numTreesHelper(after);
                    }
                    hmp.put(n, result);
                    return result;
                }
            }
        }

        Helper h = new Helper();
        return h.numTreesHelper(n);
    }


    public static void main(String[] args) {
        LC096_Unique_Binary_Search_Trees testCase = new LC096_Unique_Binary_Search_Trees();

        assert testCase.numTrees(3) == 5 : "Example 1";
        assert testCase.numTrees(4) == 14 : "Additional 1";
        assert testCase.numTrees(19) == 1767263190 : "Long 1";

        System.out.println("All passed");
    }
}

