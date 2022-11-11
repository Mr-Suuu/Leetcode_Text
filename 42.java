// 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

// 算法思想：基于双指针的思想，分别求当前列的左侧和右侧的最高列高，然后取最小值后与当前列高相减若大于0即为当前列可装雨水量
class Solution {
    public int trap(int[] height) {
        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            // 第一列和最后一列不装雨水
            if (i == 0 || i == height.length - 1){
                continue;
            }
            int lHeight = 0;
            int rHeight = 0;
            // 左边
            for (int j = 0; j < i; j++) {
                if (height[j] > lHeight){
                    lHeight = height[j];
                }
            }
            // 右边
            for (int j = i+1; j < height.length; j++) {
                if (height[j] > rHeight){
                    rHeight = height[j];
                }
            }
            int h = Math.min(lHeight, rHeight) - height[i];
            if (h > 0){
                sum += h;
            }
        }
        return sum;
    }
}

// 算法思想：基于单调栈的思想，找到左右的最高位置从而计算当前可装雨水量
class Solution {
    public int trap(int[] height) {
        int size = height.length;
        if (size < 2){
            return 0;
        }
        int sum = 0;
        Stack<Integer> st = new Stack<>();

        st.push(0);
        for (int i = 1; i < size; i++) {
            int stackTop = st.peek();
            if (height[i] < height[stackTop]){
                st.push(i);
            }else if (height[i] == height[stackTop]){
                st.pop();
                st.push(i);
            }else {
                int heightAtIdx = height[i];  // 当前位置高度
                while (!st.isEmpty() && heightAtIdx > height[stackTop]){
                    int mid = st.pop();
                    if (!st.isEmpty()){
                        int left = st.peek();
                        int h = Math.min(height[left], height[i]) - height[mid];
                        int w = i - left - 1;
                        int hold = h * w;
                        if (hold > 0){
                            sum += hold;
                        }
                        stackTop = st.peek();
                    }
                }
                st.push(i);
            }
        }
        return sum;
    }
}