// 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。

// 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。

// 假设每一种面额的硬币有无限个。

// 题目数据保证结果符合 32 位带符号整数。


// 算法思想：基于完全背包问题的思想
class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount+1];
        dp[0] = 1; // 初始化背包
        // 物品在外，背包在内是组合数，背包在外，物品在内是排列数
        for (int i = 0; i < coins.length; i++) {
            // 完全背包问题遍历顺序是从前到后，即一件物品可以出现多次
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j-coins[i]]; // 当前位置可能的组合顺序是当前位置目标金额减去当前拥有金额的金额数的组合相加
            }
        }
        return dp[amount];
    }
}