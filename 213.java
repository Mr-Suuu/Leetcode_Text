// 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。

// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        // 成环考虑三种情况，不包含首尾元素，只包含首不包含尾，只包含尾不包含首（包含不一定要选）
        // 后两种又包括了第一种情况，因此只考虑后两种即可
        return Math.max(robAction(nums, 0, nums.length-1), robAction(nums, 1, nums.length));
    }

    private int robAction(int[] nums, int start, int end) {
        if (start == end){
            return nums[start];
        }
        if (start == nums.length-1){ // start已经指向最后一个元素
            return nums[start];
        }
        int[] dp = new int[nums.length+1];
        dp[start] = nums[start];
        dp[start+1] = Math.max(nums[start], nums[start+1]);
        for (int i = start + 2; i < end; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[end-1];
    }
}

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 0 || nums == null){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }
        // 成环考虑三种情况，不包含首尾元素，只包含首不包含尾，只包含尾不包含首（包含不一定要选）
        // 后两种又包括了第一种情况，因此只考虑后两种即可
        return Math.max(robAction(nums, 0, nums.length-1), robAction(nums, 1, nums.length));
    }

    private int robAction(int[] nums, int start, int end) {
        int prepre = 0, pre = 0, cur = 0;
        for (int i = start; i < end; i++) {
            pre = cur;
            cur = Math.max(pre, prepre + nums[i]);
            prepre = pre;
        }
        return cur;
    }
}