// 给你两个 非递增 的整数数组 nums1​​​​​​ 和 nums2​​​​​​ ，数组下标均 从 0 开始 计数。

// 下标对 (i, j) 中 0 <= i < nums1.length 且 0 <= j < nums2.length 。如果该下标对同时满足 i <= j 且 nums1[i] <= nums2[j] ，则称之为 有效 下标对，该下标对的 距离 为 j - i​​ 。​​

// 返回所有 有效 下标对 (i, j) 中的 最大距离 。如果不存在有效下标对，返回 0 。

// 一个数组 arr ，如果每个 1 <= i < arr.length 均有 arr[i-1] >= arr[i] 成立，那么该数组是一个 非递增 数组。

// 算法思想：基于二分查找，先确定nums1中一个数，然后使用二分查找法在nums2中查找第一个大于等于该数的数的下标
class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
    	int len1 = nums1.length, len2 = nums2.length;
    	int res = 0, max = 0;
    	for (int i = 0; i < len1; i++) {
    		// 先确定nums1中一个数，然后使用二分查找法在nums2中查找第一个大于等于该数的数的下标
    		int left = 0, right = len2 - 1;
    		int ans = -1;

    		while(left <= right){
    			int mid = left + ((right - left) >> 1);
    			if (nums2[mid] >= nums1[i]) {
    				ans = mid;
    				left = mid + 1;
    			}else {
    				right = mid - 1;
    			}
    		}
    		if (ans != -1) {
    			res = ans - i;
    			if (max < res) {
    				max = res;
    			}
    		}
    	}	
    	return max;
    }
}