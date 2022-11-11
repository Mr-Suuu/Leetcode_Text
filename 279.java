// 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。

// 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

// 算法思想：基于完全背包的思想，将完全平方数作为物品，整数n作为背包容量
class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            for (int j = i*i; j <= n; j++) {
                if (dp[j-i*i] != Integer.MAX_VALUE){
                    dp[j] = Math.min(dp[j], dp[j-i*i] + 1);
                }
            }
        }
        return dp[n];
    }
}