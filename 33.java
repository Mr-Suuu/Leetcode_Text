// 整数数组 nums 按升序排列，数组中的值 互不相同 。

// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。

// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。

// 算法思想：暴力求解，直接循环找下标
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(nums[i] == target){
                return i;
            }
        }
        return -1;
    }
}

// 算法思想：基于二分查找，通过判断最左边元素和mid元素之间的大小可以判断左边和右边是哪一边有序
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        if (len == 0){
            return -1;
        }
        if (len == 1){
            return nums[0] == target ? 0 : -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target){
                return mid;
            }
            // 判断mid左边有序还是右边有序
            if (nums[0] <= nums[mid]){ // 左边有序
                if (nums[0] <= target && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else { // 右边有序
                if (nums[mid] < target && target <= nums[len - 1]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}