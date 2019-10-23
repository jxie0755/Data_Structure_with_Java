/**
 * https://leetcode.com/problems/zigzag-conversion/
 * P006 ZigZag Conversion
 * Medium
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * n = 3
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * n = 4
 * P     I     N
 * A   L S7  I G
 * Y A   H R 11
 * P     I
 * <p>
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 */
class LC006_Zigzag_Conversion {

    /**
     * Version B, Time O(N), spaceO(1)
     * Direct conversion line by line
     */
    public String convert(String s, int numRows) {

        if (numRows == 1) {
            return s;
        }

        int step = 2 * numRows - 2;
        StringBuilder zigzag = new StringBuilder();

        for (int i = 0; i < numRows; i += 1) {
            for (int j = i; j < s.length(); j += step) {
                zigzag.append(s.charAt(j));
                int additional = j + (numRows - 1 - i) * 2;
                if (0 < i && i < numRows - 1 && additional < s.length()) {
                    zigzag.append(s.charAt(additional));
                }
            }
        }

        return zigzag.toString();

    }


    public static void main(String[] args) {

        assert new LC006_Zigzag_Conversion().convert("", 3).equals("") : "Edge 1";
        assert new LC006_Zigzag_Conversion().convert("A", 1).equals("A") : "Edge 2";
        assert new LC006_Zigzag_Conversion().convert("AB", 1).equals("AB") : "Edge 3";

        assert new LC006_Zigzag_Conversion().convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR") : "Example 1";
        assert new LC006_Zigzag_Conversion().convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI") : "Example 2";

        System.out.println("all passed");

    }
}

