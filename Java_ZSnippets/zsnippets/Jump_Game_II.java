package zsnippets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Jump_Game_II {

    // this is to solve Leetcode 45 with recursion method similar to python

    List<Integer> nums = new ArrayList<>();
    List<Integer> all_ways = new ArrayList<>();
    Integer last_idx;


    public Jump_Game_II (List<Integer> nums) {
        this.last_idx = nums.size() - 1;
        this.nums = nums;
    }


    Integer jump() {
        this.jumpHelper(0, 0);
        return Collections.min(this.all_ways);
    }

    void jumpHelper(Integer cur_idx, Integer cur_step){
        if (cur_idx >= this.last_idx) {
            this.all_ways.add(cur_step);
        } else {
            Integer cur_value = this.nums.get(cur_idx);
            for (int i = 1; i <= cur_value; i += 1) {
                this.jumpHelper(cur_idx + i, cur_step + 1);
            }
        }
    }

    public static void main(String[] args) {
        Jump_Game_II Edge_1 = new Jump_Game_II(new ArrayList<>(Arrays.asList(2,1)));
        System.out.println(Edge_1.jump());  // 1

        Jump_Game_II Edge_2 = new Jump_Game_II(new ArrayList<>(Arrays.asList(2,3,1,1,4)));
        System.out.println(Edge_2.jump());  // 2

        Jump_Game_II Long_1 = new Jump_Game_II(new ArrayList<>(Arrays.asList(5,6,5,3,9,8,3,1,2,8,2,4,8,3,9,1,0,9,4,6,5,9,8,7,4,2,1,0,2)));
        System.out.println(Long_1.jump());

        // Jump_Game_II Long_2 = new Jump_Game_II(new ArrayList<>(Arrays.asList(5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5)));
        // System.out.println(Long_2.jump());



    }

}

