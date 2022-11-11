// 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

// 子数组 是数组中的一个连续部分。

// 算法思想：基于贪心的思想，每当和小于0时，就重置开始位置并让和为0重新计算，记录最大的局部和
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            sum = Math.max(sum, count); // 取最大值
            // ↓贪心算法的思想
            if (count <= 0){ // 若和小于0，则重置起始位置重新计数
                count = 0;
            }
        }
        return sum;
    }
}

// 算法思想：基于动态规划的思想，dp数组中保存当前位置下的最大和
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int[] dp = new int[nums.length];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // 比较前一位的最大值加上当前位 与 当前位数字的大小
            dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }
}