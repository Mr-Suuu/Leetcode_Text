// 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。

// 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。


// 算法思想：使用二分查找法对x进行查找
class Solution {
    public int mySqrt(int x) {
        long left = 0;
        long right = x;
        long ans = -1;
        while (left <= right){
            long mid = left + ((right - left) >> 1);
            if (mid * mid <= x){
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return (int)ans;
    }
}