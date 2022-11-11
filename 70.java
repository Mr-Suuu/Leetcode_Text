// 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

// 算法思想：与斐波那契数列类似，第I层可由第I-1层走一步或I-2层走两步实现
class Solution {
    public int climbStairs(int n) {
        if (n == 1){
            return 1;
        }
        if (n == 2){
            return 2;
        }
        int a = 1, b = 2;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}

// 算法思想：基于完全背包的思想
class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1; // 初始化dp数组
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 2; j++) { // 有两种走法，一步或两步
                if(i >= j){
                    dp[i] += dp[i-j];
                }
            }
        }
        return dp[n];
    }
}