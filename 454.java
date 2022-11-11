// 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：

// 0 <= i, j, k, l < n
// nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0

// 算法思想：
// 首先定义 一个unordered_map，key放a和b两数之和，value 放a和b两数之和出现的次数。
// 遍历大A和大B数组，统计两个数组元素之和，和出现的次数，放到map中。
// 定义int变量count，用来统计 a+b+c+d = 0 出现的次数。
// 在遍历大C和大D数组，找到如果 0-(c+d) 在map中出现过的话，就用count把map中key对应的value也就是出现次数统计出来。
// 最后返回统计值 count 就可以了
class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
    	Map<Integer, Integer> map = new HashMap<>();
    	int res = 0;
    	for (int i : nums1) { // 循环遍历求和数组1和数组2并放入HashMap中
    		for (int j : nums2) {
    			int temp = i + j;
    			if (map.containsKey(temp)) {
    				map.put(temp, map.get(temp) + 1);
    			}else {
    				map.put(temp, 1);
    			}
    		}
    	}
    	for (int i : nums3) {
    		for (int j : nums4) {
    			int sub = 0 - (i + j);
    			if (map.containsKey(sub)) { // 查找差值在HashMap中是否存在
    				res += map.get(sub);
    			}
    		}
    	}
    	return res;
    }
}