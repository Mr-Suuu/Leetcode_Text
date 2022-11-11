// 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

// 如果可以，返回 true ；否则返回 false 。

// magazine 中的每个字符只能在 ransomNote 中使用一次。

// 算法思想：基于哈希表思想，
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
    	int[] record = new int[26]; // 用于保存字母个数
    	for (char c : ransomNote.toCharArray()) {
    		record[c - 'a'] += 1; // 记录每个字母出现的次数
    	}
    	for (char c: magazine.toCharArray()) {
    		record[c - 'a'] -= 1;
    	}
    	for (int i : record) {
    		if (i > 0) {
    			return false;
    		}
    	}
    	return true;
    }
}