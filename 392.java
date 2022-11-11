// 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。

// 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。

// 进阶：

// 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？

// 算法思想：基于动态规划的思想，这里考虑的是最大公共子串长度是否等于s的长度
class Solution {
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        int res = 0;
        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < t.length() + 1; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                res = res > dp[i][j] ? res : dp[i][j];
            }

        }
        return res == s.length();
    }
}

// 算法思想：基于动态规划的思想，这里考虑的是若s和t不相同，则删除t中的元素，比较i-1位置和j-2位置的元素，最终判断dp[i][j]位置是否等于s的长度
class Solution {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = s.length();
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if (dp[len1][len2] == len1){
            return true;
        }else {
            return false;
        }
    }
}