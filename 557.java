// 给定一个字符串 s ，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。

// 算法思想：首先将字符串按空格切割，然后每个部分分别逆序，最后拼接起来即可
class Solution {
    public String reverseWords(String s) {
        String[] arrs = s.split(" ");
        String result = "";
        for (String arr : arrs) {
            String temp = "";
            for (int i = 0; i < arr.length(); i++) {
                temp += arr.substring(arr.length() - 1 - i, arr.length() - i);
            }
            result += temp + " ";
        }
        return result.substring(0, result.length() - 1);
    }
}

// 方法二：构建一个新的字符串并逐个逐个单词进行逆置
class Solution {
    public String reverseWords(String s) {
        StringBuffer ret = new StringBuffer();
        int length = s.length();
        int i = 0;
        while (i < length) {
            int start = i;
            while (i < length && s.charAt(i) != ' ') {
                i++;
            }
            for (int p = start; p < i; p++) {
                ret.append(s.charAt(start + i - 1 - p));
            }
            while (i < length && s.charAt(i) == ' ') {
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }
}
