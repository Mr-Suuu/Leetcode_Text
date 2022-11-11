// 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。

// 求在该柱状图中，能够勾勒出来的矩形的最大面积。

// 算法思想：基于单调栈的思想，将元素由小到大存入栈中，目的是找到左右最近的比当前矮的位置
class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<Integer>();
        // 在原数组两侧各加一个0
        int[] newHeights = new int[heights.length + 2];
        newHeights[0] = 0;
        newHeights[newHeights.length - 1] = 0;
        for (int i = 0; i < heights.length; i++) {
            newHeights[i+1] = heights[i];
        }
        heights = newHeights;
        st.push(0);
        int result = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[st.peek()]){
                // 若当前元素比栈顶元素大则入栈
                st.push(i);
            }else if (heights[i] == heights[st.peek()]){
                st.pop();
                st.push(i);
            }else {
                while (heights[i] < heights[st.peek()]){
                    int mid = st.peek();
                    st.pop();
                    int left = st.peek();
                    int right = i;
                    int w = right - left - 1;
                    int h = heights[mid];
                    result = Math.max(result, w * h);
                }
                st.push(i);
            }
        }
        return result;
    }
}