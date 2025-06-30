package dsa.practice.hierarchical;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Heap {

    private int size = 0;
    private int capacity = 5;
    private int[] data = new int[capacity];

    public void add(int value) {
        // Ensure enough space
        if (size == capacity) {
            int newCapacity = capacity * 2;
            data = Arrays.copyOf(data, newCapacity);
            capacity = newCapacity;
        }
        // Add
        data[size] = value;
        size++;
        this.heapifyUp();
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return data[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        int value = data[0];
        data[0] = data[size - 1];
        size--;
        heapifyDown();
        return value;
    }

    private void heapifyUp() {
        int index = size - 1;
        while (hasParent(index)) {
            int parentIndex = getParentIndex(index);
            if (data[parentIndex] > data[index]) {
                swap(index, parentIndex);
                index = parentIndex;
            } else {
                break;
            }
        }
    }

    private void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerValueChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && data[getRightChildIndex(index)] < data[getLeftChildIndex(index)]) {
                smallerValueChildIndex = getRightChildIndex(index);
            }
            if (data[smallerValueChildIndex] < data[index]) {
                swap(index, smallerValueChildIndex);
                index = smallerValueChildIndex;
            } else {
                break;
            }
        }
    }

    private boolean hasParent(int index) {
        if (index == 0) {
            return false;
        }
        return true;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private void swap(int indexA, int indexB) {
        int tmp = data[indexA];
        data[indexA] = data[indexB];
        data[indexB] = tmp;
    }
}
