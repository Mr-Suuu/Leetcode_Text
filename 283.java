// 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

// 请注意 ，必须在不复制数组的情况下原地对数组进行操作。

// 算法思想：基于快慢指针的思想，慢指针指向当前判断是否要后移的元素，快指针指向向前替换的元素，同时分别判断是否为0
class Solution {
    public void moveZeroes(int[] nums) {
        int slowIndex = 0;
        for (int fastIndex = 1; fastIndex < nums.length; fastIndex++) {
            if (nums[slowIndex] == 0){
                if (nums[fastIndex] != 0){
                    int temp = nums[slowIndex];
                    nums[slowIndex] = nums[fastIndex];
                    nums[fastIndex] = temp;
                    slowIndex++;
                }
            }else {
                slowIndex++;
            }
        }
    }
}

// 算法思想：基于双指针，left左边表示均为非零数，right左边直到left处均为0，相当于将0往后移动
class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while (right < nums.length){
            if (nums[right] != 0){
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }
    public void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}