// 基于栈处理
class Solution {
    // 算法思想：利用栈判断
    public boolean backspaceCompare(String s, String t) {
        return build(s).equals(build(t));
    }

    public String build(String str){
        StringBuffer ret = new StringBuffer();
        int length = str.length();
        for(int i = 0; i < length; i++){
            char ch = str.charAt(i);
            if(ch != '#'){
                ret.append(ch);
            }else{
                if(ret.length() > 0){
                    ret.deleteCharAt(ret.length() - 1);
                }
            }
        }
        return ret.toString();
    }
}


// 双指针方法
class Solution {
    public boolean backspaceCompare(String s, String t){
		// 双指针算法思想：从后往前遍历，若遇到#则令skip++，当遇到
		// 非#时判断skip是否>0，若大于则跳过并skip--，两者比较对应位置的非#元素
		int i, j, skipS, skipT;
		i = s.length() - 1;
		j = t.length() - 1;
		skipS = 0;
		skipT = 0;
		while(i >= 0 || j >= 0){
			// 首先找到s字符串从后往前第一个保留的字符
			while(i >= 0){ 
				char ret = s.charAt(i);
				if (ret == '#') {
					skipS++;
					i--;
				}else if (skipS > 0) { // 若前面有出现过#且未用完则跳过
					skipS--;
					i--;
				}else {
					break;
				}
			}

			// 首先找到t字符串从后往前第一个保留的字符
			while(j >= 0){ 
				char ret = t.charAt(j);
				if (ret == '#') {
					skipT++;
					j--;
				}else if (skipT > 0) { // 若前面有出现过#且未用完则跳过
					skipT--;
					j--;
				}else {
					break;
				}
			}

			if (i >= 0 && j >= 0) { // 此时还有元素剩余未进行判断或刚好都判断完了
				if (s.charAt(i) != t.charAt(j)) {
					return false;
				}
			}else {
				// (i >= 0 && j >= 0) 为 false 情况为
	            // 1. i < 0 && j >= 0
	            // 2. j < 0 && i >= 0
	            // 3. i < 0 && j < 0
	            // 第三种情况是符合题意的，因此需要进行处理
	            if (i >= 0 || j >= 0) { //只要有某一个大于等于0就是情况1或2
	            	return false;
	            }
			}
			// 判断完该位置后往前一个位置继续判断
            i--;
            j--;
		}
        return true;
	}
}


// 算法思想：使用栈存放两个字符串中的元素并进行比较
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#'){
                st1.push(c);
            }else {
                if (!st1.isEmpty()){
                    st1.pop();
                }
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (c != '#'){
                st2.push(c);
            }else {
                if (!st2.isEmpty()){
                    st2.pop();
                }
            }
        }
        if (st1.size() != st2.size()){
            return false;
        }else {
            while (!st1.isEmpty()){
                char c1 = st1.pop();
                char c2 = st2.pop();
                if (c1 != c2){
                    return false;
                }
            }
        }
        return true;
    }
}