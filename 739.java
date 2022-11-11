// 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。如果气温在这之后都不会升高，请在该位置用 0 来代替。

// 算法思想：基于单调栈的思想，通过栈保存元素递减序列的下标，直至有比栈顶元素大的时候出栈并计算距离
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int lens = temperatures.length;
        int[] res = new int[lens];

        Deque<Integer> stack = new LinkedList<>();

        // 保存元素下标
        stack.push(0);

        for (int i = 1; i < lens; i++) {
            if (temperatures[i] <= temperatures[stack.peek()]){
                // 若当前元素比栈顶元素小则入栈
                stack.push(i);
            }else {
                while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                    // 若当前栈不为空且当前元素比栈顶元素大，则保存结果并弹出栈顶元素
                    res[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                // 比较完之后将元素入栈
                stack.push(i);
            }
        }
        return res;
    }
}