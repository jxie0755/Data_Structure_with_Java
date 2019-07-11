import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * P017 Letter Combination of a Phone Number
 * Medium
 *
 *
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LC017_Letter_Combination_Of_A_Phone_Number {

    /**
     *  Version A, hashtable
     *  Time:  O(n * 3^n)
     */
    public List<String> letterCombinations(String digits) {

    }

    public static void main(String[] args) {

        List<String> a1 = new ArrayList<>();
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("").equals(a1): "Edge 1";

        List<String> a2 = new ArrayList<>(Arrays.asList(""));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("1").equals(a2): "Edge 2";

        List<String> a3 = new ArrayList<>(Arrays.asList(" "));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("0").equals(a3): "Edge 3";

        List<String> a4 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("2").equals(a4): "Example 1";

        List<String> a5 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("20").equals(a5): "Example 2";
        List<String> a6 = new ArrayList<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("23").equals(a6): "Example 3";
        List<String> a7 = new ArrayList<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("213").equals(a7): "Example 4";

        System.out.println("all passed");

    }


}

