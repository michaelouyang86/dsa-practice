package dsa.problems.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/summary-ranges
public class SummaryRanges {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0) {
            return Collections.emptyList();
        }

        List<String> ranges = new ArrayList<>();
        int start = 0;
        while (start < nums.length) {
            int end = getEnd(nums, start);
            if (start == end) {
                ranges.add(String.valueOf(nums[start]));
            } else {
                ranges.add(String.valueOf(nums[start]) + "->" + String.valueOf(nums[end]));
            }
            start = end + 1;
        }
        return ranges;
    }

    private int getEnd(int[] nums, int start) {
        int end = start;
        while (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) {
            end++;
        }
        return end;
    }
}
