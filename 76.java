// 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

// 算法思想：使用双指针，分别指向s中子串的开始位置和结束位置，先记录所需字符个数，然后逐个判断s中的字符是否是所需的，若不是则跳过该字符
//          若是所需字符，则判断当前拥有数量是否大于所需数量，若小于则拥有数+1，否则count不进行操作，然后该字符的拥有数量+1，结束位置右移，
//          再判断当前子串是否全覆盖t，若已全覆盖则右移起始位置，若起始位置不是所需元素则直接右移，
//          若是所需元素，则count-1，并右移一位起始位置，该元素拥有数-1，下一步将继续右移结束位置找新的覆盖子串
//          最后判断是否存在子串并返回
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.equals("") || t.equals("") || s.length() < t.length()){
            return "";
        }
        // ASCII码一共有128个
        int[] need = new int[128];
        int[] have = new int[128];
        for (int i = 0; i < t.length(); i++) {
            need[t.charAt(i)]++;
        }
        int left = 0, right = 0, start = 0, count = 0, min = s.length() + 1;
        while (right < s.length()){
            char c = s.charAt(right); // 获取当前需要判断的字符

            // 不需要该字符则跳过本次循环
            if (need[c] == 0){
                right++;
                continue;
            }

            // 当前拥有的小于需要的则加入子串中
            if (have[c] < need[c]){
                count++;
            }
            have[c]++;
            right++;

            // 当当前子串已经包含t中所有字符，则右移起始位置直至不满足包含
            while (count == t.length()){
                // 若当前子串长度更短，则更新最短子串长度及开始位置
                if (right - left < min){
                    min = right - left;
                    start = left;
                }
                // 获取子串最左边元素
                char l = s.charAt(left);
                if (need[l] == 0){
                    // 若子串最左边元素不是所需的，则直接右移起始位置并跳出本次循环
                    left++;
                    continue;
                }

                // 若是所需元素，则相当于删除已有元素
                if (have[l] == need[l]){
                    count--;
                }
                have[l]--; // 当前拥有的数量-1
                // 移动左指针
                left++;
            }
        }
        // 没有子串
        if (min == s.length() + 1){
            return "";
        }else {
            return s.substring(start, start + min);
        }
    }
}