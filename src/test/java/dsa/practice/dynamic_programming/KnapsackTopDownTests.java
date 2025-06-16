package dsa.practice.dynamic_programming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import dsa.practice.dynamic_programming.KnapsackTopDown.Item;

public class KnapsackTopDownTests {

    KnapsackTopDown knapsack = new KnapsackTopDown();

    @Test
    void testBasicCase() {
        List<Item> items = List.of(
            new Item(1, 1),
            new Item(2, 4),
            new Item(3, 5),
            new Item(4, 7)
        );
        assertEquals(12, knapsack.getLargestValue(7, items));
    }

    @Test
    void testZeroCapacity() {
        List<Item> items = List.of(
            new Item(1, 10)
        );
        assertEquals(0, knapsack.getLargestValue(0, items));
    }

    @Test
    void testEmptyItems() {
        List<Item> items = new ArrayList<>();
        assertEquals(0, knapsack.getLargestValue(10, items));
    }

    @Test
    void testSingleItemFits() {
        List<Item> items = List.of(
            new Item(5, 100)
        );
        assertEquals(100, knapsack.getLargestValue(5, items));
    }

    @Test
    void testSingleItemTooHeavy() {
        List<Item> items = List.of(
            new Item(10, 100)
        );
        assertEquals(0, knapsack.getLargestValue(5, items));
    }

    @Test
    void testAllItemsTooHeavy() {
        List<Item> items = List.of(
            new Item(10, 20),
            new Item(11, 30)
        );
        assertEquals(0, knapsack.getLargestValue(5, items));
    }

    @Test
    void testMultipleOptimalCombinations() {
        List<Item> items = List.of(
            new Item(2, 6),
            new Item(2, 10),
            new Item(3, 12)
        );
        assertEquals(22, knapsack.getLargestValue(5, items));
    }

    @Test
    void testComplexCase() {
        List<Item> items = List.of(
            new Item(1, 1),
            new Item(3, 8),
            new Item(4, 11),
            new Item(5, 15),
            new Item(6, 18),
            new Item(7, 22),
            new Item(8, 25)
        );
        // Items: (7, 22) and (8, 25)
        assertEquals(47, knapsack.getLargestValue(15, items));
    }
}
