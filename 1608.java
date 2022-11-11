// 给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而 x 是该数组的 特征值 。

// 注意： x 不必 是 nums 的中的元素。

// 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的 。


// 算法思想：暴力求解
class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums); // 首先对数组进行排序
        int max = nums[nums.length - 1]; // 获取最大值
        for (int i = 1; i <= max; i++) {
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >= i) {
                    count++; // 记录有几个数比i大
                }
            }
            if (i == count) {
                return i;
            }
        }
        return -1;
    }
}

// 算法思想：基于二分查找（还没看懂）