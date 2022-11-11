// 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

// 算法思想：基于滑动窗口的思想，若遇到相同元素则将窗口收缩到该元素下一个位置并重新开始，否则窗口扩张
class Solution {
    public int lengthOfLongestSubstring(String s) {
    	// 保存元素及其下标
        HashMap<Character, Integer> map = new HashMap<>();
    	int left = 0, right = 0, maxLen = 0;
    	for (int i = 0; i < s.length(); i++) {
    		// 若有该元素则将left移动到原该元素的下一个位置
    		if (map.containsKey(s.charAt(i))) {
    			left = Math.max(left, map.get(s.charAt(i)) + 1);
    		}
    		map.put(s.charAt(i), i); // 更新位置
    		// 更新最大长度
    		maxLen = Math.max(maxLen , i-left+1);
    	}
    	return maxLen;
    }
}