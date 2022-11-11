// 给定一个含有 n 个正整数的数组和一个正整数 target 。

// 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组[numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。

// 算法思想：基于滑动窗口的思想，若当前窗口内的和小于target，就end++，若大于则start--，若等于则记录长度并比较获得最短长度
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    	int start = 0, end = 0, ret = Integer.MAX_VALUE, sum = 0,flag = 1;
    	// flag = 1表示上一次是end++, flag = 0表示上一次时start++
    	// 初始flag为1，使得第一次进入时可以将第一个元素加入sum中
    	while(end < nums.length){
    		// 判断特殊情况，第一个元素即满足
    		if (nums[end] >= target) {
    			return 1;
    		}

    		if (flag == 1) {
    			sum += nums[end];
    		}else {
    			sum -= nums[start - 1];
    		}

    		if (sum >= target) {
    			ret = Math.min(ret, end - start + 1); // 判断当前长度是否最小
    			start++;
    			flag = 0;
    		}else {
    			end++;
    			flag = 1;
    		}
    	}
    	return ret;
    }
}


// 基于滑动窗口，但做出优化使用while循环替代flag，节省时间，空间 
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    	int start = 0, end = 0, ret = Integer.MAX_VALUE, sum = 0;
    	for(; end < nums.length; end++){
            sum += nums[end];
            while(sum >= target){
            	// 使用while循环替代上面的flag并减少循环次数
                ret = Math.min(ret, end - start + 1);
                sum -= nums[start++];
            }
        }
        return ret == Integer.MAX_VALUE ? 0 : ret;
    }
}