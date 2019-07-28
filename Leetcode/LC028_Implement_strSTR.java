/**
 * p028 implement strStr()
 * Easy
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
 */
public class LC028_Implement_strSTR {

    /**
     * Version A
     */
    public int strStr(String haystack, String needle) {
        int length = needle.length();
        int index = 0;
        while (index <= haystack.length() - length) {
            if (haystack.substring(index, index + length).equals(needle)) {
                return index;
            }
            index += 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        assert new LC028_Implement_strSTR().strStr("", "a") == -1 : "Edge 0";
        assert new LC028_Implement_strSTR().strStr("", "") == 0 : "Edge 1";

        assert new LC028_Implement_strSTR().strStr("abcdeabcde", "de") == 3 : "Examle 1";
        assert new LC028_Implement_strSTR().strStr("abcdeabcde", "zz") == -1 : "Example 2";

        System.out.println("all passed");
    }
}