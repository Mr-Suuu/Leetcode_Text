// 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。

// 你可以对一个单词进行如下三种操作：

// 插入一个字符
// 删除一个字符
// 替换一个字符

// 算法思想：基于动态规划的思想，dp数组保存的是 i-1 和 j-1 子串要相同的最少操作步骤，本体中注意添加操作可相当于删除操作
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        // 初始化dp数组
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    // 一个字符串添加一个元素等于另一个字符串删除一个元素，因此可用删除操作替代添加操作
                    // dp[i-1][j-1]+1 是指替换一个元素
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+1);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}