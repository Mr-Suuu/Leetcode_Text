// 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

// 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0){
            return 0;
        }
        // 第一个维度代表天数
        // 第二个维度代表五个状态，分别是不操作，第一次买入，第一次卖出，第二次买入，第二次卖出
        int[][] dp = new int[len][5];
        // 初始化第一天的时候若进行两次买卖操作
        dp[0][1] = -prices[0];
        dp[0][3] = -prices[0];
        for (int i = 1; i < len; i++) {
            // 比较当天的第一次买入和前一天的买入价取最大值
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
            // 比较前一天的利润与今天卖出后的利润取最大值
            dp[i][2] = Math.max(dp[i-1][2], prices[i] + dp[i-1][1]);
            // 比较当天的第二次买入和前一天的第二次买入价，此时要考虑第一次卖出后的利润取最大值
            dp[i][3] = Math.max(dp[i-1][3], dp[i-1][2] - prices[i]);
            // 比较前一天第二次卖出后的利润和当天卖出后的利润取最大值
            dp[i][4] = Math.max(dp[i-1][4], prices[i] + dp[i-1][3]);
        }
        return dp[len-1][4]; // 返回最终的最大值
    }
}