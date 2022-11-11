// 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。

// 在 S 上反复执行重复项删除操作，直到无法继续删除。

// 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。

// 算法思想：基于栈，若当前元素和栈顶元素相同则一起删去，最终栈中剩余的元素即为不是相邻重复元素
class Solution {
    public String removeDuplicates(String s) {
        // 若只有0个或1个元素时直接返回
        if (s.length() < 2) {
            return s;
        }
        // 创建栈
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.push(c);
            }else {
                char top = stack.peek();
                // 若相同则弹出栈顶元素删除
                if (c == top) {
                    stack.pop()
                }else { // 不相同则加入
                    stack.push(c);
                }
            }
        }
        return String.valueOf(stack);
    }
}

// 算法思想：用字符串代替栈，节省了栈转为字符串的过程
class Solution {
    public String removeDuplicates(String s) {
        StringBuffer res = new StringBuffer();
        int top = 0; // 字符串的长度
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (top > 0 && res.charAt(top) == c) {
                res.deleteCharAt(top--);
            }else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }
}

// 方法三：双指针（不熟）
class Solution {
    public String removeDuplicates(String s) {
        char[] ch = s.toCharArray();
        int fast = 0;
        int slow = 0;
        while(fast < s.length()){
            // 直接用fast指针覆盖slow指针的值
            ch[slow] = ch[fast];
            // 遇到前后相同值的，就跳过，即slow指针后退一步，下次循环就可以直接被覆盖掉了
            if(slow > 0 && ch[slow] == ch[slow - 1]){
                slow--;
            }else{
                slow++;
            }
            fast++;
        }
        return new String(ch,0,slow);
    }
}