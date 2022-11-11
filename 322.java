// 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

// 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

// 你可以认为每种硬币的数量是无限的。

// 算法思想：基于完全背包的思想
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        // 初始化为最大值
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j-coins[i]] != Integer.MAX_VALUE){
                    // 若有可能组合才进行比较
                    dp[j] = Math.min(dp[j], dp[j-coins[i]] + 1);
                }
            }
        }
        if (dp[amount] == Integer.MAX_VALUE){
            return -1;
        }else {
            return dp[amount];
        }
    }
}