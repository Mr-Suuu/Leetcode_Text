// 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）：

// 0 <= a, b, c, d < n
// a、b、c 和 d 互不相同
// nums[a] + nums[b] + nums[c] + nums[d] == target
// 你可以按 任意顺序 返回答案 。

// 算法思想：先固定一个i，再固定一个j，然后设置双指针查找符合目标的组合，然后先循环j再循环i，与三数之和思想一致
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 首先对数组进行排序
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
        	// 若重复则跳过本次循环
        	if (i > 0 && nums[i - 1] == nums[i]) {
        		continue
        	}

        	for (int j = i + 1; j < nums.length; j++) {
        		// 若重复则跳过本次循环
        		if (j > i + 1 && nums[j - 1] == nums[j]) {
        			continue;
        		}

        		int left = j + 1;
        		int right = nums.length - 1;
        		while(right > left){
        			int sum = nums[i] + nums[j] + nums[left] + nums[right];
        			if (sum > target) {
        				right--;
        			}else if (sum < target) {
        				left++;
        			}else{
        				result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

        				// 跳过相邻重复元素
        				while(right > left && nums[right] == nums[right - 1]){
        					right--;
        				}
        				while(right > left && nums[left] == nums[left + 1]){
        					left++;
        				}

        				left++;
        				right--;
        			}
        		}
        	}
        	return result;
        }
    }
}