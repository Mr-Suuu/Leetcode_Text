// 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。

// 有效字符串需满足：

// 左括号必须用相同类型的右括号闭合。
// 左括号必须以正确的顺序闭合

// 算法思想：基于栈先进先出的思想，遇到左括号入栈，右括号出栈并比较是否为同类型左括号
class Solution {
    public boolean isValid(String s) {
    	if (s.length() % 2 != 0) {
    		return false;
    	}

    	// 创建栈进行判断
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			// 左括号入栈
			if (c == '(' || c == '[' || c == '{') {
				Stack.push(c);
			}else {
				// 若栈中已无左括号，则直接返回false
				if (stack.isEmpty()) {
					return false;
				}

				// 若栈中还有左元素
				char top = stack.pop();
				//对应匹配
				if(c == ')' && top != '('){
					return false;
				} 
				if(c == ']' && top != '['){
					return false;
				}
				if(c == '}' && top != '{'){
					return false;
				}
			}
		}
		return stack.isEmpty(); // 最后再判断栈中是否还有多余元素
    }
}