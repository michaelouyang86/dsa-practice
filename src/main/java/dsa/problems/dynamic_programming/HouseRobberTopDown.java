package dsa.problems.dynamic_programming;

import java.util.Arrays;

// https://leetcode.com/problems/house-robber
public class HouseRobberTopDown {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, 0, memo);
    }

    private int rob(int[] nums, int index, int[] memo) {
        // base case
        if (index >= nums.length) {
            return 0;
        }
        // memo
        if (memo[index] != -1) {
            return memo[index];
        }
        // dp process
        int take = nums[index] + rob(nums, index + 2, memo);
        int skip = rob(nums, index + 1, memo);
        memo[index] = Math.max(take, skip);
        return memo[index];
    }
}
