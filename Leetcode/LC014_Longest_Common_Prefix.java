import java.util.*;

/**
 * p014 Longest Common Prefix
 * Easy
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LC014_Longest_Common_Prefix {

    /**
     * Version A, Set method
     */
    public String longestCommonPrefix(String[] strs) {

        StringBuilder result = new StringBuilder();

        if (strs.length == 0) {
            return "";
        }

        String min_length_str = Collections.min(Arrays.asList(strs), new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < min_length_str.length(); i += 1) {
            Character[] temp = new Character[strs.length];
            for (int j = 0; j < strs.length; j += 1) {
                temp[j] = strs[j].charAt(i);
            }
            Set<Character> set = new HashSet<>(Arrays.asList(temp));
            if (set.size() == 1) {
                result.append(temp[0]);
            } else {
                break;
            }
        }

        return result.toString();


    }

    public static void main(String[] args) {

        String[] l1 = new String[]{"Denis Xie", "Dennis X", "Dendi Den", "Denn"};
        assert new LC014_Longest_Common_Prefix().longestCommonPrefix(l1).equals("Den") : "regular test";

        String[] l2 = new String[]{};
        assert new LC014_Longest_Common_Prefix().longestCommonPrefix(l2).equals("") : "empty";

        System.out.println("all passed");

    }
}

