// 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

// 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词

// 算法思想：遍历第一个字符串，记录每个字母出现的次数，然后遍历第二个字符串对记录的字母--，若最后数组有不为0的即不是异位词
class Solution {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26]; // 保存26个字母出现的次数
		for (char c : s.toCharArray()) {
		  	record[c - 'a'] += 1;
		}
		for (char c : t.toCharArray()) {
			record[c - 'a'] -= 1;
		}
		for (int i : record) {
			if (i != 0) {
				return false;
			}
		}
		return true;
    }
}