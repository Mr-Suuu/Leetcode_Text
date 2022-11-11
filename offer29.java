// 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。


// 算法思想：与螺旋矩阵类似
class Solution {
    public int[] spiralOrder(int[][] matrix) {'
        // 判断特殊的矩阵形式
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        // 获取行数列数
        int rows = matrix.length, columns = matrix[0].length;
        // 构建相同大小的数组
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        // 按照右下左上的顺序遍历，遍历完一圈就缩圈
        while (left <= right && top <= bottom) {
            // →
            for (int column = left; column <= right; column++) {
                order[index++] = matrix[top][column];
            }
            // ↓
            for (int row = top + 1; row <= bottom; row++) {
                order[index++] = matrix[row][right];
            }

            if (left < right && top < bottom) {
                // 
                for (int column = right - 1; column > left; column--) {
                    order[index++] = matrix[bottom][column];
                }
                for (int row = bottom; row > top; row--) {
                    order[index++] = matrix[row][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}


// 方法2
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        // 判断特殊情况
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int m = matrix.length; // 行数
        int n = matrix[0].length; //列数
        int[] res = new int[m*n];
        int pos = 0;
        // 根据右下左上的顺序进行遍历，并循环一圈就缩圈
        int left = 0, right = n - 1, top = 0, bottom = m - 1;
        while(left < right && top < bottom){
            // →
            for (int i = 0; i < right - left; i++) {
                res[pos++] = matrix[top][left+i];
            }

            // ↓
            for (int i = 0; i < bottom - top; i++) {
                res[pos++] = matrix[top+i][right];
            }

            // ←
            for (int i = 0; i < right - left; i++) {
                res[pos++] = matrix[bottom][right-i];
            }

            // ↑
            for (int i = 0; i < bottom - top; i++) {
                res[pos++] = matrix[bottom-i][left];
            }
            if(bottom == top && right == left){
                res[pos++] = matrix[top][left];
            }
            top++;
            left++;
            right--;
            bottom--;
        }
        // 如果只剩单行或单列，就直接循环写入
        if(top == bottom){
            for(int i = 0; i <= right - left; i++){
                res[pos++] = matrix[top][left+i];
            }
        }else if(left == right){
            for(int i = 0; i <= bottom - top; i++){
                res[pos++] = matrix[top+i][left];
            }
        }
        return res;
    }
}



class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0){
            return new int[0];
        }
        int[] res = new int[matrix[0].length * matrix.length];
        int l = 0, b = matrix.length - 1, r = matrix[0].length-1, t = 0;
        int num = matrix[0].length * matrix.length;
        int k = 0;
        while (k < num){
            for (int i = l; i <= r & k < num; i++) {
                res[k++] = matrix[t][i];
                
            }
            t++;
            for (int i = t; i <= b & k < num; i++) {
                res[k++] = (matrix[i][r]);
            }
            r--;
            for (int i = r; i >= l & k < num; i--) {
                res[k++] = (matrix[b][i]);
            }
            b--;
            for (int i = b; i >= t & k < num; i--) {
                res[k++] = (matrix[i][l]);
            }
            l++;
        }
        return res;
    }
}