import java.util.*;

/**
 * P017 Letter Combination of a Phone Number
 * Medium
 * <p>
 * <p>
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LC017_Letter_Combination_Of_A_Phone_Number {

    final static Map<String, List<String>> hashtable = new HashMap<>();

    static {
        hashtable.put("0", new ArrayList<>(Arrays.asList(" ")));
        hashtable.put("1", new ArrayList<>(Arrays.asList("")));
        hashtable.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        hashtable.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        hashtable.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        hashtable.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        hashtable.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        hashtable.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        hashtable.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        hashtable.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
    }


    /**
     * Version A, hashtable
     * Time:  O(n * 3^n)
     */
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        int i = 0;

        while (i != digits.length()) {
            String current = digits.substring(i, i + 1);

            if (i == 0) {
                result = hashtable.get(current);
            } else {
                List<String> new_list = hashtable.get(current);
                List<String> new_result = new ArrayList<>();
                for (String j : result) {
                    for (String k : new_list) {
                        new_result.add(j + k);
                    }
                }
                result = new_result;
            }
            i += 1;
        }
        return result;
    }

    public static void main(String[] args) {

        List<String> a1 = new ArrayList<>();
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("").equals(a1) : "Edge 1";

        List<String> a2 = new ArrayList<>(Arrays.asList(""));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("1").equals(a2) : "Edge 2";

        List<String> a3 = new ArrayList<>(Arrays.asList(" "));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("0").equals(a3) : "Edge 3";

        List<String> a4 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("2").equals(a4) : "Example 1";

        List<String> a5 = new ArrayList<>(Arrays.asList("a ", "b ", "c "));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("20").equals(a5) : "Example 2";
        List<String> a6 = new ArrayList<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("23").equals(a6) : "Example 3";
        List<String> a7 = new ArrayList<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        assert new LC017_Letter_Combination_Of_A_Phone_Number().letterCombinations("213").equals(a7) : "Example 4";

        System.out.println("all passed");

    }


}

