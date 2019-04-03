package zsnippets;

import java.util.*;

public class Jump_Game_II {

    // this is to solve Leetcode 45 with recursion method similar to python


    Integer jump(List<Integer> nums) {

        Integer last_idx = nums.size() - 1;
        List<Integer> all_ways = new ArrayList<>();

        Map<Integer, Integer> hmp = new HashMap<>();
        for (int i = 0; i < nums.size(); i += 1) {
            hmp.put(i, Integer.MAX_VALUE);
        }

        // 需要注意的是, 内部类不是先被确定存在, 运行时才查看变量位置, 而是一开始就确定所有变量
        // 所以, 外部类中的先决变量必须放在这个内部类定义之前 (内部类的位置不能任意摆放)
        class JumpHelp {
            void helper(Integer cur_idx, Integer cur_step) {
                Integer cur_value = nums.get(cur_idx);

                if (cur_value >= last_idx - cur_idx) {
                    all_ways.add(cur_step+1);
                } else if (cur_step < hmp.get(cur_idx)){
                    hmp.replace(cur_idx, cur_step);
                    for (int i = 1; i <= cur_value; i += 1) {
                        this.helper(cur_idx + i, cur_step + 1);
                    }
                }
            }
        }


        JumpHelp inner = new JumpHelp();
        inner.helper(0, 0);

        if (nums.size() <= 1) {
            return 0;
        }
        return Collections.min(all_ways);

    }


    public static void main(String[] args) {
        assert (new Jump_Game_II().jump(new ArrayList<>(Arrays.asList(2,1)))) == 1;
        assert (new Jump_Game_II().jump(new ArrayList<>(Arrays.asList(2,3,1,1,4)))) == 2;
        assert (new Jump_Game_II().jump(new ArrayList<>(Arrays.asList(5,6,5,3,9,8,3,1,2,8,2,4,8,3,9,1,0,9,4,6,5,9,8,7,4,2,1,0,2)))) == 5;
        assert (new Jump_Game_II().jump(new ArrayList<>(Arrays.asList(5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5)))) == 5;

        System.out.println("All passed");
    }

}

