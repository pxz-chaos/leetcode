package com.peixin.data.structure.day02;

import org.junit.Test;

/**
 * @ClassName _121_买卖股票的最佳时机
 * @Author pxz_chaos
 * @Date 2022/7/13 21:44
 */
public class _121_买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        //dp[i]表示截止到i，价格的最低点是多少   dp[i]=min(dp[i-1],nums[i])
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = (dp[i - 1] < prices[i]) ? dp[i - 1] : prices[i];
            max = (prices[i] - dp[i]) > max ? prices[i] - dp[i] : max;
        }

        return max;
    }


    @Test
    public void test() {
        int[] prices = {};
        System.out.println(maxProfit2(prices));
    }

    /**
     * 暴力法
     *
     * @param prices
     * @return
     */
    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > max) {
                    max = profit;
                }

            }
        }

        return max;
    }

    /**
     * 动态规划
     *
     * @param prices
     * @return
     */
    public int maxProfit3(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int minPrice = prices[0], max = 0;
        for (int i = 1; i < prices.length; i++) {
            int profit = prices[i] - minPrice;
            if (profit > max) {
                max = profit;
            }
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            }
        }
        return max;
    }
}
