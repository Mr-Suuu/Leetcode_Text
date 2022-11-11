// 根据 逆波兰表示法，求表达式的值。

// 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。

// 注意 两个整数之间的除法只保留整数部分。

// 可以保证给定的逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况

// 算法思想：逆波兰表示法即后缀表示法，要将其转为中缀表达式，首先将数字依次入栈，然后当遇到运算符时将最上面两个元素出栈并计算，
//          然后将运算结果入栈，重复上述步骤直至数组为空
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<>();
        for (String s : tokens){
            if ("+".equals(s)){
                nums.push(nums.pop() + nums.pop());
            }else if ("-".equals(s)){
                nums.push(-nums.pop() + nums.pop()); // 注意减数、被减数顺序
            }else if ("*".equals(s)){
                nums.push(nums.pop() * nums.pop());
            }else if ("/".equals(s)){
                int right = nums.pop();
                int left = nums.pop();
                nums.push(left / right);
            }else {
                nums.push(Integer.valueOf(s));
            }
        }
        return nums.pop(); //最后栈中剩下的数即为结果
    }
}