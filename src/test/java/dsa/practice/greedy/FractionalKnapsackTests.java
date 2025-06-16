package dsa.practice.greedy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import dsa.practice.greedy.FractionalKnapsack.Item;

public class FractionalKnapsackTests {

    FractionalKnapsack knapsack = new FractionalKnapsack();

    @Test
    void testSingleItemFitsExactly() {
        List<Item> items = Arrays.asList(new Item(10, 60));
        float result = knapsack.getLargestValue(10, items);
        assertEquals(60.0f, result);
    }

    @Test
    void testSingleItemNeedsToBeSplit() {
        List<Item> items = Arrays.asList(new Item(10, 60));
        float result = knapsack.getLargestValue(5, items);
        assertEquals(30.0f, result);
    }

    @Test
    void testMultipleItemsSomeSplit() {
        List<Item> items = Arrays.asList(
            new Item(10, 60),
            new Item(20, 100),
            new Item(30, 120)
        );
        float result = knapsack.getLargestValue(50, items);
        assertEquals(240.0f, result); // 20+10 full, 2/3 of 30
    }

    @Test
    void testZeroCapacity() {
        List<Item> items = Arrays.asList(new Item(10, 60));
        float result = knapsack.getLargestValue(0, items);
        assertEquals(0.0f, result);
    }

    @Test
    void testEmptyItemsList() {
        List<Item> items = new ArrayList<>();
        float result = knapsack.getLargestValue(50, items);
        assertEquals(0.0f, result);
    }

    @Test
    void testItemWithZeroValue() {
        List<Item> items = Arrays.asList(
            new Item(10, 0),
            new Item(20, 100)
        );
        float result = knapsack.getLargestValue(20, items);
        assertEquals(100.0f, result);
    }

    @Test
    void testFractionalOrderDoesNotMatter() {
        List<Item> items = Arrays.asList(
            new Item(30, 120), // 4
            new Item(10, 60), // 6
            new Item(20, 100) // 5
        );
        float result = knapsack.getLargestValue(50, items);
        assertEquals(240.0f, result);
    }
}
