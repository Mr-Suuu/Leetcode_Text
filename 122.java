// 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。

// 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。

// 返回你能获得的最大利润。

// 算法思想：基于贪心的思想，若利润为正则购买并卖出
class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int sub = prices[i+1] - prices[i];
            if (sub > 0){
                sum += sub;
            }
        }
        return sum;
    }
}

// 算法思想：基于动态规划实现，由于是可多次买卖，因此在买入时现金要考虑之前获取的利润
class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices == null){
            return 0;
        }
        int len = prices.length;
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        // dp[i][0]表示第i天持有该股票的资金数
        // dp[i][1]表示第i天不持有该股票的资金数
        for (int i = 1; i < len; i++) {
            //                                  ↓由于可多次买卖，因此要考虑之前的利润
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], prices[i] + dp[i][0]);
        }
        return dp[len-1][1];
    }
}