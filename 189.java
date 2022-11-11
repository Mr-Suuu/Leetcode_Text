// 给你一个数组，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。

// 算法思想：从K位置分割，将前一半和后一半数组分别进行逆置，最后将整个数组逆置即可得到结果
class Solution {
    public void rotate(int[] nums, int k) {
    	k %= nums.length; // 防止k的值溢出比数组长度更长，因为移动数组长度次数即等于没有移动，因此只用移动余数次即可
    	reverse(nums, 0, nums.length - k - 1); // 逆置前面n-k个元素
    	reverse(nums, nums.length - k, nums.length-1); // 逆置后面k个元素
    	reverse(nums, 0, nums.length-1); // 最后将整个数组逆置
    }

    // 将数组逆置
    public void reverse(int[] nums, int start, int end){
    	while(start < end){
    		int temp = nums[start];
    		nums[start] = nums[end];
    		nums[end] = temp;
    		start++;
    		end--;
    	}
    }
}