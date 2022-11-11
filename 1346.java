// 给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。

// 更正式地，检查是否存在两个下标 i 和 j 满足：

// i != j
// 0 <= i, j < arr.length
// arr[i] == 2 * arr[j]

// 算法思想：暴力循环求解
class Solution {
    public boolean checkIfExist(int[] arr) {
    	for (int i = 0; i < arr.length; i++) {
    		for (int j = 0; j < arr.length; j++) {
    			if (i != j && arr[i] * 2 == arr[j]) {
    				return true;
    			}
    		}
    	}
    	return false;
    }
}

// 算法思想：先排序，然后每个数作为target，乘以2使用二分查找找是否有相同的数
class Solution {
    public boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            int target = arr[i] * 2;
            int left = 0, right = arr.length - 1;
            while(left <= right){
                int mid = left + ((right - left) >> 1);
                if (mid != i && arr[mid] == target) {
                    return true;
                }else if (arr[mid] <= target) { // 注意这里要加一个等于的判断，要不然遇到0会死循环
                    left = mid + 1;
                }else if (arr[mid] > target) {
                    right = mid - 1;
                }
            }
        }
        return false;
    }
}