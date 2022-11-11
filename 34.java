// 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

// 如果数组中不存在目标值 target，返回[-1, -1]

class Solution {
    public int[] searchRange(int[] nums, int target) {
    	int len = nums.length;
    	int left = 0, right = len - 1;
    	int[] pos = new int[]{-1, -1};
    	while(left < right){
    		int mid = left + ((right - left) >> 1);
    		if (nums[mid] == target) {
    			if (mid > pos[1]) {
    				pos[1] = mid;
    			}else if (mid < pos[0]) {
    				pos[0] = mid;
    			}
    		}else if (nums[mid] > target) {
    			right = mid - 1;
    		}else if (nums[mid] < target) {
    			left = mid + 1;
    		}
    	}
    	return pos;
    }
}

// 算法思路：使用二分法进行查找第一个大于等于target和第一个大于等于target+1的元素下标
class Solution {
    // 先找>=target的第一个
    // 再找>target的第一个
    public int[] searchRange(int[] nums, int target) {
        int x1 = search(nums, target); // 查找第一个大于等于target的元素下标
        int x2 = search(nums, target + 1); // 查找第一个大于等于target+1的元素下标
        if (x1 == -1 || nums[x1] != target){
            int[] res = new int[]{-1, -1};
            return res;
        }else if (x1 != -1 && x2 == -1){
            return new int[]{x1, x1};
        }else {
            int[] res = new int[]{x1, x2-1};
            return res;
        }
    }

    // 找>=target的第一个
    public int search(int[] nums,int target){
        int left = 0, right = nums.length - 1;
        int ans = -1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return ans;
    }
}


class Solution {
    //先找>=target的第一个
    //再找>target的第一个
    public int[] searchRange(int[] nums, int target) {
        int l = search(nums, target);
        int r = search(nums,target+1);
        // 判断l位置是否是超出范围或不是目标值，若满足该条件则直接返回-1， -1
        if(l == nums.length || nums[l] != target)
            return new int[]{-1, -1};
        return new int[]{l, r-1};
    }

    //找>=target的第一个
    public int search(int[] nums, int target){
        int left = 0, right= nums.length - 1;
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(nums[mid] >= target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}