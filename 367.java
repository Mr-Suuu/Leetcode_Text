// 给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。

// 进阶：不要 使用任何内置的库函数，如  sqrt 。


// 算法思想：
class Solution {
    public boolean isPerfectSquare(int num) {
    	long l = 0, r = num;
    	while(l <= r){
    		long mid = l + ((r - l) >> 1);
    		if (mid*mid == num) {
    			return true;
    		}else if (mid*mid < num) {
    			l = mid + 1;
    		}else if (mid*mid > num) {
    			r = mid - 1;
    		}
    	}
    	return false;
    }
}