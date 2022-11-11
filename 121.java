// 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null){
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        // dp[i][0]表示第i天持有该股票的最大收益
        // dp[i][1]表示第i天不持有该股票的最大收益
        // 初始化第一天购入时价格
        dp[0][0] -= prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], -prices[i]); // 找到最小买入价格
            //                     ↓当前价格减去前面i-1天的最小买入价格即为当前卖出可得的收益
            dp[i][1] = Math.max(prices[i] + dp[i-1][0], dp[i-1][1]); // 找到最大差价
        }
        return dp[len-1][1];
    }
}