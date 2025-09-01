package dsa.problems.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

// https://leetcode.com/problems/kth-largest-element-in-an-array
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        // build max heap
        int size = nums.length;
        int startIndex = (size - 1) / 2;
        for (int index = startIndex; index >= 0; index--) {
            heapifyDown(nums, size, index);
        }
        // remove first k - 1
        for (int i = 1; i < k; i++) {
            swap(nums, 0, size - 1);
            size--;
            heapifyDown(nums, size, 0);
        }
        // return kth largest
        return nums[0];
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private boolean hasLeftChild(int size, int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int size, int index) {
        return getRightChildIndex(index) < size;
    }

    private void heapifyDown(int[] nums, int size, int index) {
        while (hasLeftChild(size, index)) {
            int largerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(size, index) && nums[getRightChildIndex(index)] > nums[largerChildIndex]) {
                largerChildIndex = getRightChildIndex(index);
            }
            if (nums[largerChildIndex] > nums[index]) {
                swap(nums, largerChildIndex, index);
                index = largerChildIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int[] nums, int indexA, int indexB) {
        int tmp = nums[indexA];
        nums[indexA] = nums[indexB];
        nums[indexB] = tmp;
    }

    public int findKthLargestPriorityQueueMaxHeap(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        for (int i = 1; i < k; i++) {
            priorityQueue.poll();
        }
        return priorityQueue.peek();
    }

    public int findKthLargestPriorityQueueMinHeap(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.offer(num);
            if (priorityQueue.size() > k) {
                priorityQueue.poll();
            }
        }
        return priorityQueue.peek();
    }
}
