/**
 * https://leetcode.com/problems/implement-strstr/
 * p028 implement strStr()
 * Easy
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
 */
class LC028_Implement_strSTR {

    /**
     * Version A
     */
    public int strStr(String haystack, String needle) {
        int length = needle.length();
        for (int index = 0; index <= haystack.length() - length; index += 1) {
            if (haystack.substring(index, index + length).equals(needle)) {
                return index;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC028_Implement_strSTR testCase = new LC028_Implement_strSTR();
        assert testCase.strStr("", "a") == -1 : "Edge 0";
        assert testCase.strStr("", "") == 0 : "Edge 1";

        assert testCase.strStr("abcdeabcde", "de") == 3 : "Examle 1";
        assert testCase.strStr("abcdeabcde", "zz") == -1 : "Example 2";

        System.out.println("All passed");
    }
}
