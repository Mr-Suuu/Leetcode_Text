// 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。

// 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。

// 算法思想：基于动态规划的思想，dp数组保存的是字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]
class Solution {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        // dp数组保存的是字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]
        int[][] dp = new int[len+1][len+1];
        // 初始化dp，对角线元素初始化为1
        for (int i = 0; i < len + 1; i++) {
            dp[i][i] = 1;
        }
        // 从后往前遍历，因为依赖于后面的数组
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i+1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][len-1];
    }
}