// 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。

// 数组中的每个元素代表你在该位置可以跳跃的最大长度。

// 判断你是否能够到达最后一个下标。

// 算法思想：基于贪心算法的思想，判断跳跃覆盖范围究竟可不可以覆盖到终点
class Solution {
    public boolean canJump(int[] nums) {
    	if (nums.length == 1) {
            return true;
        }
        int cover = 0;
        for (int i = 0; i <= cover; i++) {
            if (i <= cover){
                if (i + nums[i] > cover){
                    cover = i + nums[i]; // 若当前位置可达且从当前位置能覆盖的范围更大则更新可覆盖范围
                }
            }
            if (cover >= nums.length-1){
            	return true;
        	}
        }
        return false;
    }
}
