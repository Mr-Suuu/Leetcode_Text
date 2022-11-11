// 给你两个整数数组arr1，arr2和一个整数d，请你返回两个数组之间的距离值。

// 「距离值」定义为符合此距离要求的元素数目：对于元素arr1[i]，不存在任何元素arr2[j]满足 |arr1[i]-arr2[j]| <= d 。

// 算法思想：暴力解法，直接各位相减
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int num = 0;
        for(int i = 0; i < arr1.length; i++){
        	// 判断各位相减是否满足条件
            for(int j = 0; j < arr2.length; j++){
                if (Math.abs(arr1[i] - arr2[j]) <= d) {
                	break;
                }
            }
            // 判断是否全部满足
            if (j == arr2.length) {
            	num++;
            }
        }
        return num;
    }
}

//算法思想：对arr2排序，在arr2中找与arr[i]最相近的数，如果连最相近的数绝对值差都大于d，那么其他就更不用考虑了
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2); // 对arr2进行排序
        int cnt = 0;
        for (int x : arr1) {
        	int p = binarySearch(arr2, x); // 得到最接近x的值所在的下标
        	boolean ok = true;
        	if (p < arr2.length) { // 若下标在数组内而不是在数组最右边
        		ok &= arr2[p] - x > d; // 判断是否大于d
        	}
        	if (p-1 >= 0 && p - 1 <= arr2.length) { // 若返回的下标左边还有数即最后一个小于x的数，则也对该数进行判断
        		ok &= x - arr2[p-1] > d;
        	}
        	cnt += ok ? 1 : 0;
        }
        return cnt;
    }

    // 在arr2中寻找与X最接近的值并返回该位置下标
    public int binarySearch(int[] arr, int target){
    	int left = 0, right = arr.length - 1;
    	if (arr[right] <= target) {
    		return right + 1;  // 若最大值都小于等于target，则返回arr2.length
    	}
    	while(left < right){
    		// 跳出条件为left == right
    		int mid = left + ((right - left) >> 1);
    		if (arr[mid] < target) {
    			left = mid + 1;
    		}else {
    			right = mid;
    		}
    	}
    	return left; // 返回第一个大于等于target的值的下标
    }
}
