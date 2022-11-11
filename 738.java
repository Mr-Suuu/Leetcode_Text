// 当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。

// 给定一个整数 n ，返回 小于或等于 n 的最大数字，且数字呈 单调递增 。

// 算法思想：从后往前遍历，若当前位置小于前一个位置的数，则将前一个位置的数-1，并记录当前位置，最终记录位置起至结尾全部置为9
class Solution {
    public int monotoneIncreasingDigits(int n) {
        String[] strings = (n + "").split(""); // 将数字n切分开来
        int start = strings.length;
        for (int i = strings.length - 1; i > 0; i--) {
            if (Integer.parseInt(strings[i]) < Integer.parseInt(strings[i-1])){
                // 若当前位置小于前一个位置
                strings[i-1] = (Integer.parseInt(strings[i-1]) - 1) + ""; // 前一个位置的数-1
                start = i; // 更新要置为9的起始位置
            }
        }
        for (int i = start; i < strings.length; i++) {
            strings[i] = "9";
        }
        return Integer.parseInt(String.join("", strings));
    }
}

// 方法2：节省时间，直接在数组上进行变化，不用Integer.parseInt
class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] c = s.toCharArray();
        int start = c.length;
        for (int i = c.length - 1; i > 0; i--) {
            if (c[i] < c[i-1]){
                c[i-1]--;
                start = i;
            }
        }
        for (int i = start; i < c.length; i++) {
            c[i] = '9';
        }
        return Integer.parseInt(String.valueOf(c));
    }
}