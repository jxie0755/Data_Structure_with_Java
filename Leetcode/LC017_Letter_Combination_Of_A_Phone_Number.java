import java.util.*;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 * P017 Letter Combination of a Phone Number
 * Medium
 * <p>
 * Given a string containing digits from 2-9 inclusive,
 * return all possible letter combinations that the number could represent.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
class LC017_Letter_Combination_Of_A_Phone_Number {


    // Static helper
    final static Map<String, List<String>> hmp = new HashMap<>();
    static {
        hmp.put("0", new ArrayList<>(Arrays.asList(" ")));
        hmp.put("1", new ArrayList<>(Arrays.asList("")));
        hmp.put("2", new ArrayList<>(Arrays.asList("a", "b", "c")));
        hmp.put("3", new ArrayList<>(Arrays.asList("d", "e", "f")));
        hmp.put("4", new ArrayList<>(Arrays.asList("g", "h", "i")));
        hmp.put("5", new ArrayList<>(Arrays.asList("j", "k", "l")));
        hmp.put("6", new ArrayList<>(Arrays.asList("m", "n", "o")));
        hmp.put("7", new ArrayList<>(Arrays.asList("p", "q", "r", "s")));
        hmp.put("8", new ArrayList<>(Arrays.asList("t", "u", "v")));
        hmp.put("9", new ArrayList<>(Arrays.asList("w", "x", "y", "z")));
    }


    /**
     * Version A, hashtable
     * Time:  O(n * 3^n)
     */
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        for (int i = 0; i < digits.length(); i += 1) {

            String current = digits.substring(i, i + 1);

            if (i == 0) {
                result = hmp.get(current);
            } else {
                List<String> new_result = new ArrayList<>();
                for (String j : result) {
                    for (String k : hmp.get(current)) {
                        new_result.add(j + k);
                    }
                }
                result = new_result;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        LC017_Letter_Combination_Of_A_Phone_Number testCase = new LC017_Letter_Combination_Of_A_Phone_Number();

        List<String> a1 = new ArrayList<>();
        assert testCase.letterCombinations("").equals(a1) : "Edge 1";

        List<String> a2 = new ArrayList<>(Arrays.asList(""));
        assert testCase.letterCombinations("1").equals(a2) : "Edge 2";

        List<String> a3 = new ArrayList<>(Arrays.asList(" "));
        assert testCase.letterCombinations("0").equals(a3) : "Edge 3";

        List<String> a4 = new ArrayList<>(Arrays.asList("a", "b", "c"));
        assert testCase.letterCombinations("2").equals(a4) : "Example 1";

        List<String> a5 = new ArrayList<>(Arrays.asList("a ", "b ", "c "));
        assert testCase.letterCombinations("20").equals(a5) : "Example 2";
        List<String> a6 = new ArrayList<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        assert testCase.letterCombinations("23").equals(a6) : "Example 3";
        List<String> a7 = new ArrayList<>(Arrays.asList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"));
        assert testCase.letterCombinations("213").equals(a7) : "Example 4";

        System.out.println("All passed");

    }


}

