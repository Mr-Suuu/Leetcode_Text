// 给定一个n个元素有序的（升序）整型数组nums 和一个目标值target ，写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。

class Solution {
    public int search(int[] nums, int target) {
        if (nums[0] > target || nums[nums.length-1] < target){
            return -1;
        }
        int left = 0, right = nums.length - 1;
        // nums.length - 1 => [left, right]
        // nums.length     => [left, right)
        while (left <= right){
            int mid = left + ((right - left) >> 1);
            // 带等号：跳出条件为 left = right + 1
            // 不带等号：跳出条件为 left = right
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] > target){
                right = mid - 1;
            }
        }
        return -1;
    }
}