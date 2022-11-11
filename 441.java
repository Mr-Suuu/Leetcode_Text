// 你总共有n枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。

// 给你一个数字n ，计算并返回可形成 完整阶梯行 的总行数。

class Solution {
    public int arrangeCoins(int n) {
        long l = 0, r = n;
        long ans = 0;
        while(l <= r){ // 必须带等号，否则当l == r时直接跳出，但此时有可能仍是答案
            long mid = l + ((r - l) >> 1);
            if((1+mid)*mid/2 <= n){
                ans = mid;
                l = mid + 1; // mid已经判断过了，因此将+1跳过，若令l = mid 则可能陷入死循环
            }else{
                r = mid - 1;
            }
        }
        return (int)ans;
    }
}