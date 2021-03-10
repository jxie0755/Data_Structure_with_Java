import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/integer-to-roman/
 * LC012 Integer to Roman
 * Medium
 * <p>
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
class LC012_Integer_To_Roman {

    // Static helper
    static Map<Integer, String> R = new HashMap<>();

    static {
        R.put(0, "");
        R.put(1, "I");
        R.put(2, "II");
        R.put(3, "III");
        R.put(4, "IV");
        R.put(5, "V");
        R.put(6, "VI");
        R.put(7, "VII");
        R.put(8, "VIII");
        R.put(9, "IX");
        R.put(10, "X");
        R.put(20, "XX");
        R.put(30, "XXX");
        R.put(40, "XL");
        R.put(50, "L");
        R.put(60, "LX");
        R.put(70, "LXX");
        R.put(80, "LXXX");
        R.put(90, "XC");
        R.put(100, "C");
        R.put(200, "CC");
        R.put(300, "CCC");
        R.put(400, "CD");
        R.put(500, "D");
        R.put(600, "DC");
        R.put(700, "DCC");
        R.put(800, "DCCC");
        R.put(900, "CM");
        R.put(1000, "M");
        R.put(2000, "MM");
        R.put(3000, "MMM");
    }

    /**
     * Version A
     * Hashmap method
     */
    public String intToRoman(int num) {

        String numstr = String.valueOf(num);

        // get the r_justed number
        StringBuilder numstr_rjusted = new StringBuilder();
        for (int k = 0; k < 4 - numstr.length(); k += 1) {
            numstr_rjusted.append("0");
        }
        for (int i = 0; i < numstr.length(); i += 1) {
            numstr_rjusted.append(numstr.charAt(i));
        }

        // Convert to integers array of every digit
        Integer[] base = new Integer[]{1000, 100, 10, 1};
        Integer[] numstr_array = new Integer[4];
        for (int i = 0; i < numstr_rjusted.length(); i += 1) {
            numstr_array[i] = Integer.parseInt(numstr_rjusted.substring(i, i + 1)) * base[i];
        }

        // final result by checking the hashmap
        StringBuilder result = new StringBuilder();
        for (int i : numstr_array) {
            result.append(R.get(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        LC012_Integer_To_Roman testCase = new LC012_Integer_To_Roman();
        assert testCase.intToRoman(3888).equals("MMMDCCCLXXXVIII");
        System.out.println("All passed");
    }
}

