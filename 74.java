// 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：

// 每行中的整数从左到右按升序排列。
// 每行的第一个整数大于前一行的最后一个整数。

// 两次二分查找（代码还有问题）
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
    	int m = matrix.length; // 行数
    	int n = matrix[0].length; // 列数
    	int top = 0, bottom = m - 1;
    	// 先使用二分查找找到所在行
    	while(top < bottom){
    		int mid = top + ((bottom - top) >> 1);
    		if (matrix[mid][n-1] > target) {
    			top = mid + 1;
    		}else if (matrix[mid][n-1] == target) {
    			return true
    		}else {
    			bottom = mid - 1;
    		}
    	}
    	// 跳出时top == bottom，此时即为所在行
    	int left = 0, right = n - 1;
    	while(left < right){
    		int mid = left + ((right - left) >> 1);
    		if (matrix[top][mid] < target) {
    			right = mid - 1;
    		}else if (matrix[top][mid] == target) {
    			return true;
    		}else {
    			left = mid + 1;
    		}
    	}
    	return false;
    }
}

// 由于数组数字特性，将数组拼接成一行，再使用一次二分查找即可
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n]; // 拼接成一行
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
