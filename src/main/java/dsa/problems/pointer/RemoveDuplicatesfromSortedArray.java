package dsa.problems.pointer;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                index++;
                nums[index] = nums[i];
            }
        }
        return index + 1;
    }
}
