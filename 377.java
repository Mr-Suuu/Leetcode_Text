// 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。

// 题目数据保证答案符合 32 位整数范围。

// 算法思想：基于完全背包的思想，遍历顺序先遍历背包，再遍历物品，从而得到排序数，遍历顺序若相反则得到组合数
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        dp[0] = 1; // 初始化dp数组
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i){
                    // 若当前数大于等于目标，则计算排列数
                    dp[i] += dp[i-nums[j]];
                }
            }
        }
        return dp[target];
    }
}