package dsa.practice.sorting;

public class HeapSort {

    public void sort(int[] data) {
        buildMaxHeap(data);
        int heapSize = data.length;
        for (int i = data.length - 1; i >= 0; i--) {
            swap(data, 0, i);
            heapSize--;
            heapifyDown(data, 0, heapSize);
        }
    }

    private void buildMaxHeap(int[] data) {
        int lastHaveChildIndex = (data.length - 2) / 2;
        for (int i = lastHaveChildIndex; i >= 0; i--) {
            heapifyDown(data, i, data.length);
        }
    }

    private void heapifyDown(int[] data, int index, int heapSize) {
        while (hasLeftChild(index, heapSize)) {
            int largerValueChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index, heapSize) && data[getRightChildIndex(index)] > data[getLeftChildIndex(index)]) {
                largerValueChildIndex = getRightChildIndex(index);
            }
            if (data[largerValueChildIndex] > data[index]) {
                swap(data, index, largerValueChildIndex);
                index = largerValueChildIndex;
            } else {
                break;
            }
        }
    }

    private void swap(int[] data, int indexA, int indexB) {
        int temp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = temp;
    }

    private boolean hasLeftChild(int index, int heapSize) {
        return getLeftChildIndex(index) < heapSize;
    }

    private boolean hasRightChild(int index, int heapSize) {
        return getRightChildIndex(index) < heapSize;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }
}
