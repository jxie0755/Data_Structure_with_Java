import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 * P093 Restore IP Addresses
 * Medium
 * <p>
 * <p>
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 */
class LC093_Restore_IP_Addresses {

    List<String> RESULT = new ArrayList<>(Arrays.asList());

    /**
     * Version A2
     */
    public List<String> restoreIpAddresses(String s) {
        this.restoreIpHelper(s, "", 0);
        List<String> ans = new ArrayList<>(RESULT);
        RESULT.clear();
        return ans;
    }

    private void restoreIpHelper(String s, String address, int parts) {
        int L = Math.min(3, s.length());

        if (parts < 3) {
            for (int i = 1; i < L + 1; i += 1) {
                String group = s.substring(0, i);
                String rest = s.substring(i);
                if (group.length() == 1 || group.length() > 1 && group.charAt(0) != '0' && Integer.parseInt(group) <= 255) {
                    this.restoreIpHelper(rest, address + group + ".", parts + 1);
                }
            }
        } else if (parts == 3) {
            if (s.length() == 1 || s.length() > 1 && s.charAt(0) != '0' && Integer.parseInt(s) <= 255) {
                this.restoreIpHelper("", address + s, parts + 1);
            }
        } else {
            RESULT.add(address);
        }
    }

    public static void main(String[] args) {
        LC093_Restore_IP_Addresses testCase = new LC093_Restore_IP_Addresses();

        assert testCase.restoreIpAddresses("0000").equals(
                new ArrayList<>(Arrays.asList("0.0.0.0"))
        ) : "Edge 1";

        assert testCase.restoreIpAddresses("01000").equals(
                new ArrayList<>(Arrays.asList("0.10.0.0"))
        ) : "Edge 2";

        assert testCase.restoreIpAddresses("25525511135").equals(
                new ArrayList<>(Arrays.asList("255.255.11.135", "255.255.111.35"))
        ) : "Example 1";

        System.out.println("All passed");
    }
}

