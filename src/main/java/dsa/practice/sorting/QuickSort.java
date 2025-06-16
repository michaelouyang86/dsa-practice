package dsa.practice.sorting;

public class QuickSort {

    public void sort(int[] data) {
        sort(data, 0, data.length - 1);
    }

    private void sort(int[] data, int startIndex, int endIndex) {
        // base case
        if (startIndex >= endIndex) {
            return;
        }
        int pivotIndex = endIndex;
        int firstPointerIndex = startIndex;
        int secondPointerIndex = startIndex;
        while (secondPointerIndex < pivotIndex) {
            if (data[firstPointerIndex] <= data[pivotIndex]) {
                firstPointerIndex++;
            } else if (data[secondPointerIndex] <= data[pivotIndex]) {
                swap(data, firstPointerIndex, secondPointerIndex);
                firstPointerIndex++;
            }
            secondPointerIndex++;
        }
        swap(data, firstPointerIndex, pivotIndex);
        sort(data, startIndex, firstPointerIndex - 1);
        sort(data, firstPointerIndex + 1, endIndex);
    }

    private void swap(int[] data, int indexA, int indexB) {
        int temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }
}
