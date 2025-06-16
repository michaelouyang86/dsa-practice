package dsa.practice.sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class SortingTests {

    @Test
    void testQuickSort1() {
        int[] data = new int[] {47, 3, 99, 25, 72, 13, 65, 86, 44, 19, 91, 56, 88, 6, 28, 74, 17, 80, 30, 58};
        int[] expected = new int[] {3, 6, 13, 17, 19, 25, 28, 30, 44, 47, 56, 58, 65, 72, 74, 80, 86, 88, 91, 99};

        QuickSort quickSort = new QuickSort();
        quickSort.sort(data);

        assertArrayEquals(expected, data);
    }

    @Test
    void testQuickSort2() {
        int[] data = new int[] {
            -32, 45, 0, -99, 67, -12, 100, -45, 23, 78,
            -88, 56, -7, 3, -100, 34, -66, 15, 92, -1,
            29, -54, 60, -25, 41, -3, 81, -13, 8, -77, 3
        };

        int[] expected = new int[] {
            -100, -99, -88, -77, -66, -54, -45, -32, -25, -13,
            -12, -7, -3, -1, 0, 3, 3, 8, 15, 23, 29,
            34, 41, 45, 56, 60, 67, 78, 81, 92, 100
        };

        QuickSort quickSort = new QuickSort();
        quickSort.sort(data);

        assertArrayEquals(expected, data);
    }

    @Test
    void testMergeSort1() {
        int[] data = new int[] {47, 3, 99, 25, 72, 13, 65, 86, 44, 19, 91, 56, 88, 6, 28, 74, 17, 80, 30, 58};
        int[] expected = new int[] {3, 6, 13, 17, 19, 25, 28, 30, 44, 47, 56, 58, 65, 72, 74, 80, 86, 88, 91, 99};

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(data);

        assertArrayEquals(expected, data);
    }

    @Test
    void testMergeSort2() {
        int[] data = new int[] {
            -32, 45, 0, -99, 67, -12, 100, -45, 23, 78,
            -88, 56, -7, 3, -100, 34, -66, 15, 92, -1,
            29, -54, 60, -25, 41, -3, 81, -13, 8, -77, 3
        };

        int[] expected = new int[] {
            -100, -99, -88, -77, -66, -54, -45, -32, -25, -13,
            -12, -7, -3, -1, 0, 3, 3, 8, 15, 23, 29,
            34, 41, 45, 56, 60, 67, 78, 81, 92, 100
        };

        MergeSort mergeSort = new MergeSort();
        mergeSort.sort(data);

        assertArrayEquals(expected, data);
    }

    @Test
    void testHeapSort1() {
        int[] data = new int[] {47, 3, 99, 25, 72, 13, 65, 86, 44, 19, 91, 56, 88, 6, 28, 74, 17, 80, 30, 58};
        int[] expected = new int[] {3, 6, 13, 17, 19, 25, 28, 30, 44, 47, 56, 58, 65, 72, 74, 80, 86, 88, 91, 99};

        HeapSort heapSort = new HeapSort();
        heapSort.sort(data);

        assertArrayEquals(expected, data);
    }

    @Test
    void testHeapSort2() {
        int[] data = new int[] {
            -32, 45, 0, -99, 67, -12, 100, -45, 23, 78,
            -88, 56, -7, 3, -100, 34, -66, 15, 92, -1,
            29, -54, 60, -25, 41, -3, 81, -13, 8, -77, 3
        };

        int[] expected = new int[] {
            -100, -99, -88, -77, -66, -54, -45, -32, -25, -13,
            -12, -7, -3, -1, 0, 3, 3, 8, 15, 23, 29,
            34, 41, 45, 56, 60, 67, 78, 81, 92, 100
        };

        HeapSort heapSort = new HeapSort();
        heapSort.sort(data);

        assertArrayEquals(expected, data);
    }
}
