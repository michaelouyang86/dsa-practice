package dsa.practice.sorting;

import java.util.Arrays;

public class MergeSort {

    public void sort(int[] data) {
        // base case
        if (data.length == 1) {
            return;
        }
        int middle = data.length / 2;
        int[] left = Arrays.copyOfRange(data, 0, middle);
        int[] right = Arrays.copyOfRange(data, middle, data.length);
        sort(left);
        sort(right);
        int[] result = merge(left, right);

        for (int i = 0; i < data.length; i++) {
            data[i] = result[i];
        }
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        
        int index = 0;
        int leftIndex = 0;
        int rightIndex = 0;
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                result[index] = left[leftIndex];
                leftIndex++;
            } else {
                result[index] = right[rightIndex];
                rightIndex++;
            }
            index++;
        }

        while (leftIndex < left.length) {
            result[index] = left[leftIndex];
            leftIndex++;
            index++;
        }

        while (rightIndex < right.length) {
            result[index] = right[rightIndex];
            rightIndex++;
            index++;
        }

        return result;
    }
}
