import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * p014 Longest Common Prefix
 * Easy
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 */
public class LC014_Longest_Common_Prefix {

    /**
     * Version B, Deque method
     */
    public String longestCommonPrefix(String[] strs) {

    }

    public static void main(String[] args) {

        String[] l1 = new String[]{"Denis Xie", "Dennis X", "Dendi Den", "Denn"};
        assert new LC014_Longest_Common_Prefix().longestCommonPrefix(l1).equals("Den"): "regular test";

        String[] l2 = new String[]{};
        assert new LC014_Longest_Common_Prefix().longestCommonPrefix(l2).equals(""): "empty";

        System.out.println("all passed");

    }


}

