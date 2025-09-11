package dsa.problems.math;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
public class BestTimeToBuyAndSellStock {
    public int maxProfitOrigianl(int[] prices) {
        int maxProfit = 0;
        int buyingPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            int currentProfit = price - buyingPrice;
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit;
            }
            if (price < buyingPrice) {
                buyingPrice = price;
            }
        }
        return maxProfit;
    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
}
