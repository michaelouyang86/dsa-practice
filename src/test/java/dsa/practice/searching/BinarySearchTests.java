package dsa.practice.searching;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BinarySearchTests {

    BinarySearch binarySearch = new BinarySearch();

    @Test
    public void testEmptyArray() {
        int[] data = {};
        assertFalse(binarySearch.searchIteratively(data, 5));
        assertFalse(binarySearch.searchRecursively(data, 5));
    }

    @Test
    public void testSingleElementFound() {
        int[] data = {5};
        assertTrue(binarySearch.searchIteratively(data, 5));
        assertTrue(binarySearch.searchRecursively(data, 5));
    }

    @Test
    public void testSingleElementNotFound() {
        int[] data = {3};
        assertFalse(binarySearch.searchIteratively(data, 5));
        assertFalse(binarySearch.searchRecursively(data, 5));
    }

    @Test
    public void testMultipleElementsFoundAtStart() {
        int[] data = {1, 3, 5, 7, 9};
        assertTrue(binarySearch.searchIteratively(data, 1));
        assertTrue(binarySearch.searchRecursively(data, 1));
    }

    @Test
    public void testMultipleElementsFoundAtMiddle() {
        int[] data = {1, 3, 5, 7, 9};
        assertTrue(binarySearch.searchIteratively(data, 5));
        assertTrue(binarySearch.searchRecursively(data, 5));
    }

    @Test
    public void testMultipleElementsFoundAtEnd() {
        int[] data = {1, 3, 5, 7, 9};
        assertTrue(binarySearch.searchIteratively(data, 9));
        assertTrue(binarySearch.searchRecursively(data, 9));
    }

    @Test
    public void testMultipleElementsNotFound() {
        int[] data = {1, 3, 5, 7, 9};
        assertFalse(binarySearch.searchIteratively(data, 4));
        assertFalse(binarySearch.searchRecursively(data, 4));
    }

    @Test
    public void testNegativeNumbersFound() {
        int[] data = {-10, -5, 0, 3, 8};
        assertTrue(binarySearch.searchIteratively(data, -5));
        assertTrue(binarySearch.searchRecursively(data, -5));
    }

    @Test
    public void testNegativeNumbersNotFound() {
        int[] data = {-10, -5, 0, 3, 8};
        assertFalse(binarySearch.searchIteratively(data, -7));
        assertFalse(binarySearch.searchRecursively(data, -7));
    }

    @Test
    public void testLargeArray() {
        int[] data = new int[1000];
        for (int i = 0; i < 1000; i++) {
            data[i] = i * 2; // Even numbers
        }
        assertTrue(binarySearch.searchIteratively(data, 998));
        assertTrue(binarySearch.searchRecursively(data, 998));
        assertFalse(binarySearch.searchIteratively(data, 999));
        assertFalse(binarySearch.searchRecursively(data, 999));
    }
}
