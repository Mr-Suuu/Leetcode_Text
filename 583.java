// 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。

// 每步可以删除任意一个字符串中的一个字符。

// 算法思想：基于动态规划的思想，dp数组中保存的是以 i-1 为结尾的字符串word1，和以 j-1 位结尾的字符串word2，想要达到相等，所需要删除元素的最少次数
class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        // 初始化dp数组，dp[i][0]表示第一个字符串有i个元素，第二个字符串为空，则删除i次，同理dp[0][i]
        for (int i = 0; i < word1.length() + 1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < word2.length() + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < word1.length() + 1; i++) {
            for (int j = 1; j < word2.length() + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)){
                	// 若相同的直接与 i-1 j-1 位相同
                    dp[i][j] = dp[i-1][j-1];
                }else {
                	// 若不相同有三种情况，分别是word1删除，word2删除，word1和word2一起删除，比较这三种方法取最小值
                    dp[i][j] = Math.min(Math.min(dp[i-1][j]+1, dp[i][j-1]+1), dp[i-1][j-1]+2);
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}