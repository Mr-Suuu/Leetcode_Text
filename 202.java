// 编写一个算法来判断一个数 n 是不是快乐数。

// 「快乐数」定义为：

// 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
// 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
// 如果这个过程 结果为 1，那么这个数就是快乐数。
// 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。

// 算法思想：使用哈希法，来判断这个sum是否重复出现，如果重复了就是return false， 否则一直找到sum为1为止。
class Solution {
    public boolean isHappy(int n) {
    	Set<Integer> r = new HashSet<>();
    	while(n != 1 && !r.contains(n)){ // 若和为1或HashMap中已存在该sum则跳出
    		record.add(n);
    		n = getNextNumber(n);
    	}
    	return n == 1;
    }

    private int getNextNumber(int n){
    	int res = 0;
    	while(n > 0){
    		int temp = n % 10; // 取出每一位并平方求和
    		res += temp*temp;
    		n = n / 10;
    	}
    	return res;
    }
}