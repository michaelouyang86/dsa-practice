package dsa.problems.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/3sum
public class ThreeSum {
    public List<List<Integer>> threeSumOriginal(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int target = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int current = nums[left] + nums[right];
                if (current == target) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                } else if (current < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return result;
    }
}
