import java.util.Arrays;

/**
 * https://leetcode.com/problems/string-to-integer-atoi/
 * P008 String to Integer (atoi)
 * Medium
 * <p>
 * Implement atoi which converts a string to an integer.
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed. (Example 4)
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
 */
class LC008_String_To_Integer {

    /**
     * Version A, string method
     * Unable to pass, even with Long, need to use BigInteger
     */
    public int myAtoi(String str) {

        // Two hashmap to convert char to digit
        Character[] digits = new Character[]{
                '0', '1', '2', '3',
                '4', '5', '6', '7',
                '8', '9'};

        Character[] prefix = new Character[]{'+', '-'};

        // Get the numeric first (before decimal point)
        boolean found = false;
        StringBuilder extract = new StringBuilder();
        for (char i : str.toCharArray()) {

            if (i == ' ' && !found) {

            } else if (Arrays.asList(prefix).contains(i)
            ) {

                if (!found) {
                    extract.append(i);
                    found = true;
                } else {
                    break;
                }
            } else if (Arrays.asList(digits).contains(i)) {
                extract.append(i);
                found = true;
            } else if (i == '.') {
                break;
            } else {
                break;
            }
        }
        if (extract.length() == 0) {
            return 0;
        } else {
            Long result = 0L;
            Long base = 1L;

            for (int i = extract.length() - 1; i >= 0; i -= 1) {
                Character cur = extract.charAt(i);  // 注意这里不要用Character
                if (cur == '-' || cur == '+') {
                } else {
                    result += (long) Character.getNumericValue(cur) * base;
                    base *= 10;

                    if (result > Integer.MAX_VALUE) {
                        if (extract.charAt(0) == '-') {
                            return Integer.MIN_VALUE;
                        } else {
                            return Integer.MAX_VALUE;
                        }
                    }
                }

            }

            if (extract.charAt(0) == '-') {
                return result.intValue() * -1;
            }
            return result.intValue();

        }
    }


    public static void main(String[] args) {

        assert new LC008_String_To_Integer().myAtoi("ABC") == 0 : "Edge 1";

        assert new LC008_String_To_Integer().myAtoi("42") == 42 : "Example 1";
        assert new LC008_String_To_Integer().myAtoi("   -42") == -42 : "Example 2";
        assert new LC008_String_To_Integer().myAtoi("4193 with words") == 4193 : "Example 3";
        assert new LC008_String_To_Integer().myAtoi("words and 987") == 0 : "Example 4";
        assert new LC008_String_To_Integer().myAtoi("-91283472332") == -2147483648 : "Example 5, 32 bit overflow";
        assert new LC008_String_To_Integer().myAtoi("3.14159") == 3 : "Extra 1";
        assert new LC008_String_To_Integer().myAtoi("+1") == 1 : "Extra 2";
        assert new LC008_String_To_Integer().myAtoi("+-2") == 0 : "Extra 3";
        assert new LC008_String_To_Integer().myAtoi("-0012a42") == -12 : "Extra 4";
        assert new LC008_String_To_Integer().myAtoi("+0 123") == 0 : "Extra 5";
        assert new LC008_String_To_Integer().myAtoi("-5-") == -5 : "Extra 6";
        assert new LC008_String_To_Integer().myAtoi("9223372036854775808") == 2147483647 : "Extra 7";
        assert new LC008_String_To_Integer().myAtoi("10000000000000000000000522545459") == 2147483647 : "Extra 8, Beyong Long";

        System.out.println("all passed");
    }

}

