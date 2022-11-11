// 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

// 算法思想：相当于令和的一半作为背包总容量，数组元素相当于物品重量，dp[j]表示 背包总容量是j，最大可以凑成j的子集总和为dp[j]，若背包容量为总和一半的时候子集总和也为总和一半，
//          则表示可以平分
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0 || nums == null){
            return false;
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0){
            // 若为奇数则必然不可能平分
            return false;
        }
        int target = sum/2;
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            // nums相当于物品重量
            for (int j = target; j >= nums[i]; j--) { // 这里j >= nums[i]是因为若背包容量小于物品重量则无意义
                dp[j] = Math.max(dp[j], dp[j-nums[i]]+nums[i]);
            }
        }
        if (dp[target] == target){ // 若子集总和为目标值，则可以平分
            return true;
        }else {
            return false;
        }
    }
}
