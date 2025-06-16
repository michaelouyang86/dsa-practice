package dsa.practice.dynamic_programming;

import java.util.List;

public class KnapsackTopDown {

    public int getLargestValue(int capacity, List<Item> items) {
        int[][] memo = new int[capacity + 1][items.size() + 1];
        for (int i = 0; i < capacity + 1; i++) {
            for (int j = 0; j < items.size() + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return getLargestValue(capacity, items, 0, memo);
    }

    private int getLargestValue(int remainingCapacity, List<Item> items, int itemIndex, int[][] memo) {
        // Return memoized result if it exists
        if (memo[remainingCapacity][itemIndex] != -1) {
            return memo[remainingCapacity][itemIndex];
        }
        // Base cases: if remaining capacity is 0 or no items left to consider
        if (remainingCapacity == 0 || itemIndex >= items.size()) {
            return 0;
        } else if (items.get(itemIndex).weight > remainingCapacity) {
            return getLargestValue(remainingCapacity, items, itemIndex + 1, memo);
        } else {
            int takeCurrentItem = items.get(itemIndex).value + getLargestValue(remainingCapacity - items.get(itemIndex).weight, items, itemIndex + 1, memo);
            int notTakeCurrentItem = getLargestValue(remainingCapacity, items, itemIndex + 1, memo);
            return Math.max(takeCurrentItem, notTakeCurrentItem);
        }
    }

    public static class Item {
        private int weight;
        private int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}
