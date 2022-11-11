// 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。

// 注意：答案中不可以包含重复的三元组。

// 算法思想：基于双指针思想
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
    	List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // 先对数组进行排序操作
        for (int i = 0; i < nums.length; i++) {
        	// 若当前数大于0则后面都大于0，所以相加无论如何都不能等于0，所以直接返回
        	if (nums[i] > 0) { 
        		return result; 
        	}
        	// 若该数和前一个数相同则直接跳过，因为不能有重复的数组
        	if (i > 0 && nums[i] == nums[i-1]) {
        		continue;
        	}

        	int left = i + 1, right = nums.length - 1;
        	while(left < right){
        		int sum = nums[i] + nums[left] + nums[right];
        		if (sum == 0) {
        			result.add(Arrays.asList(nums[i], nums[left], nums[right]));

        			// 跳过相同元素
        			while(right > left && nums[right] == nums[right - 1]){
        				right--; 
        			}
        			while(right > left && nums[left] == nums[left + 1]){
        				left++; 
        			}

        			right--;
        			left++;
        		}else if (sum > 0) {
        			right--;
        		}else if (sum < 0) {
        			left++;
        		} {
        			
        		}
        	}
        }
        return result;
    }
}