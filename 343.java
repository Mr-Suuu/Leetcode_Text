// 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。

// 返回 你可以获得的最大乘积 。

// 算法思想：当n<=3的时候直接返回结果，若n大于3后，dp数组中设置前三位的值分别是1，2，3，不再进行拆分，并比较不同的划分方式
class Solution {
    public int integerBreak(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 1;
        }
        if (n == 3){
            return 2;
        }
        // 从n >= 4开始动态规划
        int[] dp = new int[n+1];
        // 这里123不进行切分
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        // 一直迭代上去找到n对应的最大划分方式
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i] = Math.max(dp[i], dp[j]*dp[i-j]);
            }
        }
        return dp[n];
    }
}

// 算法思想：基于动态规划的思想，不断拆分比较取最大值
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i - j; j++) {
                // j*(i-j)表示只拆成两部分，j*dp[i-j]表示后一个数将继续拆分
                dp[i] = Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }
}