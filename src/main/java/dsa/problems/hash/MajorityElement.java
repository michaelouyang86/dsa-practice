package dsa.problems.hash;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/majority-element
public class MajorityElement {
    public int majorityElementOriginal(int[] nums) {
        int target = nums.length / 2;
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) {
            int count = counter.getOrDefault(num, 0) + 1;
            if (count > target) {
                return num;
            }
            counter.put(num, count);
        }
        throw new IllegalArgumentException("No majority element");
    }

    // Boyer–Moore majority vote algorithm
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }
}
