// n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。

// 你需要按照以下要求，给这些孩子分发糖果：

// 每个孩子至少分配到 1 个糖果。
// 相邻两个孩子评分更高的孩子会获得更多的糖果。
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。

// 算法思想：一次是从左到右遍历，只比较右边孩子评分比左边大的情况。
//         一次是从右到左遍历，只比较左边孩子评分比右边大的情况。
//         若大于则糖果数目+1
class Solution {
    public int candy(int[] ratings) {
        int[] candyVec = new int[ratings.length];
        candyVec[0] = 1;
        // 从前往后遍历，比较右边比左边大的情况
        for (int i = 0; i < ratings.length - 1; i++) {
            if (ratings[i+1] > ratings[i]){
                candyVec[i+1] = candyVec[i] + 1;
            }else{
                candyVec[i+1] = 1;
            }
        }
        
        // 从后往前遍历，比较左边比右边大的情况
        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]){
                candyVec[i-1] = Math.max(candyVec[i] + 1, candyVec[i-1]);
            }
        }
        return Arrays.stream(candyVec).sum();
    }
}