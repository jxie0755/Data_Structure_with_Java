package zsnippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Jump_Game_II {

    // this is to solve Leetcode 45 with recursion method similar to python


    Integer jump(List<Integer> nums) {
        Integer last_idx = nums.size() - 1;
        List<Integer> all_ways = new ArrayList<>();

        class JumpHelp {
            void helper(Integer cur_idx, Integer cur_step) {
                if (cur_idx >= last_idx) {
                    all_ways.add(cur_step);
                } else {
                    Integer cur_value = nums.get(cur_idx);
                    for (int i = 1; i <= cur_value; i += 1) {
                        this.helper(cur_idx + i, cur_step + 1);
                    }
                }
            }
        }

        JumpHelp inner = new JumpHelp();
        inner.helper(0, 0);
        return Collections.min(all_ways);
    }



    public static void main(String[] args) {
        System.out.println(new Jump_Game_II().jump(new ArrayList<>(Arrays.asList(2,1))));  // 1
        System.out.println(new Jump_Game_II().jump(new ArrayList<>(Arrays.asList(2,3,1,1,4)))); // 2
        System.out.println(new Jump_Game_II().jump(new ArrayList<>(Arrays.asList(5,6,5,3,9,8,3,1,2,8,2,4,8,3,9,1,0,9,4,6,5,9,8,7,4,2,1,0,2)))); // 5
        // System.out.println(new Jump_Game_II().jump(new ArrayList<>(Arrays.asList(5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5)))); // 5


    }

}

