package dsa.practice.greedy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FractionalKnapsack {

    public float getLargestValue(int capacity, List<Item> items) {
        Comparator<Item> comparator = Comparator.comparingDouble(
            (Item item) -> item.value / item.weight).reversed();
        Collections.sort(items, comparator);

        float value = 0f;
        int remainingCapacity = capacity;
        for (Item item : items) {
            if (remainingCapacity >= item.weight) {
                value += item.value;
                remainingCapacity -= item.weight;
            } else {
                float fraction = (float) remainingCapacity / item.weight;
                value += fraction * item.value;
                remainingCapacity = 0;
            }
            // If the knapsack doesn't have any remaining capacity, we can stop
            if (remainingCapacity == 0) {
                break;
            }
        }
        return value;
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
