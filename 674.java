// 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。

// 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。


// 算法思想：基于贪心的思想，判断所有可能性
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int res = 1;
        int count = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1]){
                count++;
            }else {
                count = 1;
            }
            if (res < count){
                res = count;
            }
        }
        return res;
    }
}


// 算法思想：基于动态规划的思想实现
class Solution {
    public int findLengthOfLCIS(int[] nums) {
        // dp数组用于记录位置i的最长连续子序列长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int res = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i+1]){
                dp[i+1] = dp[i] + 1;
            }
            res = res > dp[i+1] ? res : dp[i+1];
        }
        return res;
    }
}