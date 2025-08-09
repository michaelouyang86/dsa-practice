package dsa.problems.pointer;

// https://leetcode.com/problems/merge-sorted-array
public class MergeSortedArray {
    public void mergeOriginal(int[] nums1, int m, int[] nums2, int n) {
        int[] result = new int[nums1.length];

        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            if (index1 >= m) {
                result[i] = nums2[index2++];
            } else if (index2 >= n) {
                result[i] = nums1[index1++];
            } else {
                if (nums1[index1] < nums2[index2]) {
                    result[i] = nums1[index1++];
                } else {
                    result[i] = nums2[index2++];
                }
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = result[i];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int index = m + n - 1;

        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[index--] = nums1[index1--];
            } else {
                nums1[index--] = nums2[index2--];
            }
        }

        while (index2 >= 0) {
            nums1[index--] = nums2[index2--];
        }
    }
}
