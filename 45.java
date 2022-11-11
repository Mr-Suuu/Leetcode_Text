// 给你一个非负整数数组 nums ，你最初位于数组的第一个位置。

// 数组中的每个元素代表你在该位置可以跳跃的最大长度。

// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。

// 假设你总是可以到达数组的最后一个位置。

// 算法思想：判断当前可达最远距离能否到终点，若能够则结束，否则步长+1并计算下一步可达的最远距离，重复上述步骤
//          即找出这一步可达的最远距离，然后再判断是否是终点，若不是则再加一步
class Solution {
    public int jump(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int ans = 0;
        int curDistance = 0;
        int nextDistance = 0;
        for (int i = 0; i < nums.length; i++) {
            nextDistance = Math.max(nums[i] + i, nextDistance); // 判断当前位置最大可达范围
            if (i == curDistance){
                // 若当前已达到当前可达最远距离
                if (curDistance != nums.length - 1){
                    // 若未到达终点
                    ans++;
                    curDistance = nextDistance;
                    if (nextDistance >= nums.length - 1){
                        // 若下一步能到达终点则直接跳出
                        break;
                    }
                }else {
                    // 若当前已能直接到达则跳出
                    break;
                }
            }
        }
        return ans;
    }
}