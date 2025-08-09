package dsa.problems.dynamic_programming;

import java.util.Arrays;

// https://leetcode.com/problems/coin-change
public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, Integer.MAX_VALUE);
        return coinChange(coins, amount, memo);
    }

    private int coinChange(int[] coins, int amount, int[] memo) {
        // amount < 0
        if (amount < 0) {
            return -1;
        }
        // amount == 0
        if (amount == 0) {
            return 0;
        }
        // amount == coin
        for (int coin : coins) {
            if (amount == coin) {
                return 1;
            }
        }
        // memo
        if (memo[amount] != Integer.MAX_VALUE) {
            return memo[amount];
        }

        // dp process
        boolean haveChanges = false;
        int fewest = Integer.MAX_VALUE;
        for (int coin : coins) {
            int coinChange = coinChange(coins, amount - coin, memo);
            if (coinChange != -1) {
                haveChanges = true;
                if (coinChange < fewest) {
                    fewest = coinChange;
                }
            }
        }
        
        int result =  haveChanges ? fewest + 1 : -1;
        memo[amount] = result;
        return result;
    }
}
