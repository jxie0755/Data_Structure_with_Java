from typing import *

class Solution:
    ### Simple Recursion method that worked but exceed max time limit
    def jump(self, nums: List[int]) -> int:

        def helper(cur_idx, cur_step=0):

            if cur_idx >= last_idx:
                all_ways.append(cur_step)
            else:
                cur_value = nums[cur_idx]
                for i in range(1, cur_value+1):
                    helper(cur_idx + i, cur_step + 1)

        last_idx = len(nums) - 1
        all_ways = []
        helper(0)
        return min(all_ways)
