// 符合下列属性的数组 arr 称为 山脉数组 ：
// arr.length >= 3
// 存在 i（0 < i < arr.length - 1）使得：
// arr[0] < arr[1] < ... arr[i-1] < arr[i]
// arr[i] > arr[i+1] > ... > arr[arr.length - 1]
// 给你由整数组成的山脉数组 arr ，返回任何满足 arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1] 的下标 i 

// 算法思想：找到第一个arr[i] > arr[i+1]的地方
class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0, r = arr.length - 1;
        int ans = 0;
        while(l <= r){
        	int mid = l + ((r - l) >> 1);
        	if (arr[mid] > arr[mid+1]) {
        		ans = mid;
        		r = mid - 1;
        	}else{
        		l = mid + 1;
        	}
        }
        return ans;
    }
}