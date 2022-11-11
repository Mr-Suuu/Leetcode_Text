// 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。

// 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：

// 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
// 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
// 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
// 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。

// 算法思想：基于滑动窗口思想，每次滑动右窗口时进行对应判断
class Solution {
    public int totalFruit(int[] fruits) {
        int len = 0; // 当前序列长度
        int first = 0; // 水果篮第一个位置
        int second = 0; // 水果篮第二个位置
        int temp = 0; // 离当下水果最近的不同连续水果的开始位置
        int result = 0; // 结果长度
        for(int point = 0; point < fruits.length; point++){ // 循环遍历数组
            if(fruits[point] != fruits[first] && fruits[point] != fruits[second]){ // 若与水果篮第一第二个位置都不相等时
                if(first != second){ // 若第一第二个位置不相等，即非初始化状态时
                    first = temp; // 将第一个开始位置更改为离当前水果最近的连续水果的位置
                }
                second = point; // 将第二个位置置为新加入元素
            }

            if(fruits[temp] != fruits[point]){ // 若记录位置连续性断了则更新新的最近连续位置
                temp = point;
            }

            len = point - first + 1; // 计算长度
            result = result < len ? len : result; // 比较记录最长长度
        }
        return result;
    }
}

// 算法思想：使用双指针，记录最大种类数为2的区间
class Solution {
    public int totalFruit(int[] fruits) {
        int len = fruits.length;
        int[] cnt = new int[len + 1];
        int ans = 0;
        // s表示当前篮子中元素种类数
        for (int end = 0, start = 0, s = 0; end < len; end++) {
            if (++cnt[fruits[end]] == 1){
                // 若是第一次放入则种类数+1
                s++;
            }
            while (s > 2){
                if (--cnt[fruits[start++]] == 0){
                    s--;
                }
            }
            ans = Math.max(ans, end - start + 1);
        }
        return ans;
    }
}