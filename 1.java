// 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。

// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。

// 你可以按任意顺序返回答案。

// 算法思想：基于HashMap，每次查看与target的差在HashMap中是否存在，若有则保存下标，否则继续查找，每次将新遍历到的数加入HashMap中
class Solution {
    public int[] twoSum(int[] nums, int target) {
    	int[] res = new int[2];
    	if (nums == null || nums.length == 0) {
    		return res;
    	}
    	Map<Integer, Integer> map = new HashMap<>();
    	for (int i = 0; i < nums.length; i++) {
    		int temp = target - nums[i];
    		if (map.contains(temp)) {
    			res[0] = i;
    			res[1] = map.get(temp); // 找到对应的下标
    		}
    		map.put(nums[i], i);
    	}
    	return res;
    }
}