// 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

// 算法思想：右下左上跑，跑完就缩圈，剩余单行列，直接遍历完
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1, tally = 1;
        // 按照→↓←↑的方向循环遍历
        while(tally <= n*n && top <= bottom && left <= right){
            // → 以三阶矩阵为例，左闭右开，一行三个只负责遍历前两位
            for(int i = 0; i < right - left; i++){
                res[top][left+i] = tally;
                tally++;
            }
            // ↓
            for(int i = 0; i < bottom - top; i++){
                res[top+i][right] = tally;
                tally++;
            }
            // ←
            for (int i = 0; i < right - left; i++) {
                res[bottom][right-i] = tally;
                tally++;
            }
            // ↑
            for (int i = 0; i < bottom - top; i++) {
                res[bottom-i][left] = tally;
                tally++;
            }
            // 若有最中间一个元素会进入while但不会执行上面四个for循环，因此要特殊处理
            if (bottom == top && left == right) {
                res[top][left] = tally;
                return res;
            }
            // 遍历完一圈缩圈
            left++;
            right--;
            top++;
            bottom--;
        }

        return res;
    }
}


