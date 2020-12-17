import java.util.Arrays;

/**
 * https://leetcode.com/problems/plus-one/
 * p066 Plus One
 * Easy
 * <p>
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 */
class LC066_Plus_One {

    /**
     * Version A
     * Convert to Arraylist and recursion then convert back
     */
    // public int[] plusOne(int[] digits) {
    //
    //     // Convert data structure to Arralylist, to be processed by helper
    //     List<Integer> arlist = new ArrayList<>();
    //     for (int i : digits) {
    //         arlist.add(i);
    //     }
    //
    //     List<Integer> result = plusOne_helper(arlist);
    //
    //     int[] array_result = new int[result.size()];
    //     for (int i = 0; i < result.size(); i += 1) {
    //         array_result[i] = result.get(i);
    //     }
    //     return array_result;
    // }
    //
    //
    // private List<Integer> plusOne_helper(List<Integer> digits) {
    //     if (digits.get(digits.size() - 1) == 9) {
    //         if (digits.size() == 1) {
    //             return new ArrayList<>(Arrays.asList(1, 0));
    //         } else {
    //             List<Integer> head = plusOne_helper(digits.subList(0, digits.size() - 1));
    //             head.add(0);
    //             return head;
    //         }
    //     } else {
    //         digits.set(digits.size() - 1, digits.get(digits.size() - 1) + 1);
    //         return digits;
    //     }
    // }


    /**
     * STD ans
     * Carry the plus on from low decimal all the way to the top
     * Expand the array if needed
     */
    public int[] plusOne(int[] digits) {

        // 进位标志, 下一位来的进位标志
        int carry = 1;
        int tmp;
        for (int i = digits.length - 1; i >= 0; i-=1) {
            tmp = digits[i];
            // 计算当前位的新值
            digits[i] = (tmp + carry) % 10;
            carry = (tmp + carry) / 10;

            if (carry == 0) {
                break;
            }
        }

        // 最后还有一个进位
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = carry;
            return result; // in java must buid a new array and return
        } else {
            return digits;
        }
    }


    public static void main(String[] args) {
        LC066_Plus_One testCase = new LC066_Plus_One();
        int[] s1 = new int[]{0};
        assert Arrays.equals(testCase.plusOne(s1), new int[]{1}) : "Edge 0";

        int[] s2 = new int[]{1, 2, 3};
        assert Arrays.equals(testCase.plusOne(s2), new int[]{1, 2, 4}) : "Example 1";

        int[] s3 = new int[]{4, 3, 2, 1};
        assert Arrays.equals(testCase.plusOne(s3), new int[]{4, 3, 2, 2}) : "Example 2";

        int[] s4 = new int[]{1, 9, 9};
        assert Arrays.equals(testCase.plusOne(s4), new int[]{2, 0, 0}) : "Example 3";

        int[] s5 = new int[]{9, 9, 9};
        assert Arrays.equals(testCase.plusOne(s5), new int[]{1, 0, 0, 0}) : "Example 4";

        System.out.println("all passed");
    }
}

