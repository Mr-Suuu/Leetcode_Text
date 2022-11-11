// 给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。

// 算法思想：对每一行进行二分查找
class Solution {
    public int countNegatives(int[][] grid) {
    	int m = grid.length; // 行数
    	int n = grid[0].length; // 列数
    	int count = 0;
    	for (int i = 0; i < m; i++) {
    		int left = 0, right = n - 1;
    		while(left <= right){
    			int mid = left + ((right - left) >> 1);
    			if (grid[i][mid] < 0) {
    				count += right - mid + 1;
    				right = mid - 1;
    			}else {
    				left = mid + 1;
    			}
    		}
    	}
    	return count;
    }
}