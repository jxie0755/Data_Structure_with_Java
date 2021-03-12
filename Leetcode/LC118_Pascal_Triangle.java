import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/pascals-triangle/
 * LC118 Pascal's triangle
 * Easy
 * <p>
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 */
class LC118_Pascal_Triangle {
    /**
     * Version A
     */
    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>(Arrays.asList(
            ));
        } else if (numRows == 1) {
            return new ArrayList<>(Arrays.asList(
                    new ArrayList<>(Arrays.asList(1))
            ));
        } else {
            List<List<Integer>> result = new ArrayList<>(Arrays.asList(
                    new ArrayList<>(Arrays.asList(1))
            ));

            List<Integer> layer = new ArrayList<>(Arrays.asList(1, 1));

            for (int i = 0; i < numRows - 1; i += 1) {
                result.add(layer);
                List<Integer> new_layer = new ArrayList<>(Arrays.asList(1));
                for (int j = 0; j < layer.size() - 1; j += 1) {
                    new_layer.add(layer.get(j) + layer.get(j + 1));
                }
                new_layer.add(1);
                layer = new_layer;
            }
            return result;
        }
    }

    public static void main(String[] args) {
        LC118_Pascal_Triangle testCase = new LC118_Pascal_Triangle();

        assert testCase.generate(0).equals(new ArrayList<>(Arrays.asList(
        ))) : "Edge 0";

        assert testCase.generate(5).equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1)),
                new ArrayList<>(Arrays.asList(1, 1)),
                new ArrayList<>(Arrays.asList(1, 2, 1)),
                new ArrayList<>(Arrays.asList(1, 3, 3, 1)),
                new ArrayList<>(Arrays.asList(1, 4, 6, 4, 1))
        ))) : "Example 1";

        assert testCase.generate(1).equals(new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1))
        ))) : "Example 2";

        System.out.println("All passed");
    }
}

