// 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。

// 算法思想： 使用双指针进行遍历求解
class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0, right = (long)Math.sqrt(c);
        while(left <= right){
            if (left*left + right*right == c) {
                return true;
            }else if (left*left + right*right > c) {
                right--;
            }else if (left*left + right*right < c) {
                left++;
            }
        }
        return false;
    }
}