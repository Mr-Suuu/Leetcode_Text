// 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。


//算法思想：先平方再排序
class Solution {
    public int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i]*nums[i];
        }

        // 冒泡排序
        for (int i = 1; i < nums.length; i++) {
            boolean flag = true;
            for(int j = 0; j < nums.length - i; j++){
                if (nums[j] > nums[j+1]) {
                    int tem = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tem;
                    flag = false;
                }
            }

            if(flag){
                break;
            }
        }
        return nums;
    }
}

// 算法思想：先平方再排序，排序调用方法
class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; ++i) {
            ans[i] = nums[i] * nums[i];
        }
        Arrays.sort(ans);
        return ans;
    }
}


//算法思想：使用双指针，分别从前往后和从后往前比较平方大小，将更大的从后往前加入数组中
class Solution {
    public int[] sortedSquares(int[] nums) {
        int i = 0, j = nums.length - 1;
        int[] ans = new int[nums.length];
        int pos = nums.length - 1;
        while(i <= j){
            if(nums[i]*nums[i] < nums[j]*nums[j]){
                ans[pos] = nums[j]*nums[j];
                j--;
            }else{
                ans[pos] = nums[i]*nums[i];
                i++;
            }
            pos--;
        }
        return ans;
    }
}