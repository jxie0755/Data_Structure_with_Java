import java.util.*;

/**
 * https://leetcode.com/problems/group-anagrams/
 * P049 Group Anagrams
 * Medium
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * Note:
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */
class LC049_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        if (strs.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        Map<Set<Character>, List<String>> hmp = new HashMap<>();

        for (String word : strs) {
            // Different from python, set can be directly used in Map
            Set<Character> anagram_key = new HashSet<>();
            for (int i = 0; i < word.length(); i += 1) {
                anagram_key.add(word.charAt(i));
            }

            if (!hmp.containsKey(anagram_key)) {
                hmp.put(anagram_key, new ArrayList<>(Arrays.asList(word)));
            } else {
                hmp.get(anagram_key).add(word);
            }
        }
        return new ArrayList<>(hmp.values());
    }

    public static void main(String[] args) {
        LC049_Group_Anagrams testCase = new LC049_Group_Anagrams();

        String[] q1 = {};
        List<String> a1l1 = new ArrayList<>(Arrays.asList());
        List<List<String>> a1 = new ArrayList<>(Arrays.asList(a1l1));
        assert testCase.groupAnagrams(q1).equals(a1) : "Edge 0";

        String[] q2 = {"a"};
        List<String> a2l1 = new ArrayList<>(Arrays.asList("a"));
        List<List<String>> a2 = new ArrayList<>(Arrays.asList(a2l1));
        assert testCase.groupAnagrams(q2).equals(a2) : "Edge 1";

        String[] q3 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> sorted_a3 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList("bat")),
                new ArrayList<>(Arrays.asList("eat", "tea", "ate")),
                new ArrayList<>(Arrays.asList("tan", "nat"))
        ));
        List<List<String>> a3 = testCase.groupAnagrams(q3);
        Collections.sort(a3, new StringListComparator());
        assert a3.equals(sorted_a3) : "Example 1";

        System.out.println("All passed");
    }
}

