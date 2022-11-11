// 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。

// 算法思想：基于动态规划的思想，从1到n分别取节点作为根节点，分别求左右子树有多少种可能性并相乘
class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 从1到i分别作为头节点
            for (int j = 1; j <= i; j++) {
                // dp[i] += dp[以j为头结点左子树节点数量] * dp[以j为头结点右子树节点数量]
                dp[i] += dp[j-1]*dp[i-j];
            }
        }
        return dp[n];
    }
}