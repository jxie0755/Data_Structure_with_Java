import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/roman-to-integer/
 * p013 Roman to Integer
 * Easy
 * <p>
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class LC013_Roman_To_Integer {

    // Static helper
    static Map<String, Integer> checklist = new HashMap<>();
    static {
        checklist.put("CM", 900);
        checklist.put("CD", 400);
        checklist.put("XC", 90);
        checklist.put("XL", 40);
        checklist.put("IX", 9);
        checklist.put("IV", 4);
    }

    static Map<String, Integer> Roman_Nu = new HashMap<>();
    static {
        Roman_Nu.put("M", 1000);
        Roman_Nu.put("D", 500);
        Roman_Nu.put("C", 100);
        Roman_Nu.put("L", 50);
        Roman_Nu.put("X", 10);
        Roman_Nu.put("V", 5);
        Roman_Nu.put("I", 1);
    }

    /**
     * Version A, hashmap method
     */
    public int romanToInt(String s) {
        int result = 0;


        for (Map.Entry<String, Integer> entry : checklist.entrySet()) {
            if (s.contains(entry.getKey())) {
                String k = entry.getKey();
                Integer v = entry.getValue();
                result += v;
                s = s.replaceFirst(k, "");
            }
        }

        for (int i = 0; i < s.length(); i += 1) {
            String sub = s.substring(i, i + 1);
            result += Roman_Nu.get(sub);
        }

        return result;
    }

    public static void main(String[] args) {

        assert new LC013_Roman_To_Integer().romanToInt("MMMCDXCIX") == 3499 : "Example 1";
        System.out.println("all passed");

    }

}

