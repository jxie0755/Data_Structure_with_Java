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
public class LC049_Group_Anagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        if (strs.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }

        Map<List<Character>, List<String>> hmp = new HashMap<>();
        for (String word : strs) {
            Set<Character> word_set = new HashSet<>(Arrays.asList());
            for (int i = 0; i < word.length(); i += 1) {
                word_set.add(word.charAt(i));
            }
            List<Character> word_set_list = new ArrayList<>(word_set);
            Collections.sort(word_set_list);

            if (!hmp.containsKey(word_set_list)) {
                hmp.put(word_set_list, new ArrayList<>(Arrays.asList(word)));
            } else {
                hmp.get(word_set_list).add(word);
            }

        }
        for (List<String> group : hmp.values()) {
            result.add(group);
        }
        return result;

    }

    public static void main(String[] args) {

        // String[] q1 = {};
        // List<String> a1l1 = new ArrayList<>(Arrays.asList());
        // List<List<String>> a1 = new ArrayList<>(Arrays.asList(a1l1));
        // assert new LC049_Group_Anagrams().groupAnagrams(q1).equals(a1);
        //
        // String[] q2 = {"a"};
        // List<String> a2l1 = new ArrayList<>(Arrays.asList("a"));
        // List<List<String>> a2 = new ArrayList<>(Arrays.asList(a2l1));
        // assert new LC049_Group_Anagrams().groupAnagrams(q2).equals(a2);
        //
        String[] q3 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<String> a3l1 = new ArrayList<>(Arrays.asList("eat", "tea", "ate"));
        List<String> a3l2 = new ArrayList<>(Arrays.asList("tan", "nat"));
        List<String> a3l3 = new ArrayList<>(Arrays.asList("bat"));
        List<List<String>> a3 = new ArrayList<>(Arrays.asList(a3l1, a3l2, a3l3));
        System.out.println((new LC049_Group_Anagrams().groupAnagrams(q3)));
        // assert new LC049_Group_Anagrams().groupAnagrams(q3).equals(a3);
        //
        // System.out.println("all passed");

        String a = "wordddddddd";


        // System.out.println(s1);

    }
}

