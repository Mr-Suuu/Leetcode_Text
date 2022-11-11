// 给定两个字符串s和 p，找到s中所有p的异位词的子串，返回这些子串的起始索引。不考虑答案输出的顺序。

// 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。

// 算法思想：基于滑动窗口思想
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 保存返回的异位词起始索引
    	List<Integer> res = new ArrayList<>(); 
        HashMap<Character, Integer> map = new HashMap<>(); 
        // 用map存储目标值中各字母出现的次数
        for (Character c : p.toCharArray()) {
            // 对元素求个数累加
            map.put(c, map.getOrDefault(c, 0) + 1); 
        }
        // 存储滑动窗口中有效字符出现的次数
        HashMap<Character, Integer> window = new HashMap<>(); 
        int left = 0, right = 0; // 定义左右指针
        // 只有当valid == 0时，才代表window中可能包含目标子串
        int valid = p.length(); 
        while(right < s.length()){
            // 如果目标子串包含了该字符，才存入window中
            if (map.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                // 当window中有效字符数量不大于map中对应字符的数量时，才能算一次有效的包含
                if (window.get(s.charAt(right)) <= map.get(s.charAt(right))) {
                    valid--;    
                }                
            }   
            // 如果window符合要求，即两个map存储的有效字符相同，就可以移动左指针，（此时可能滑动窗口内的元素个数大于p的长度，此时为不合规状态）
            // 只有两个map存储的数据完全相同时，才能记录当前起始索引，即left所在位置
            while(valid == 0){
                if (right - left + 1 == p.length()) {
                    res.add(left);
                }
                // 如果左指针指向的是有效字符，则需更改window中的key对应的value
                // 如果有效字符对应的数量比目标字串少，则说明该无法匹配
                if (map.containsKey(s.charAt(left))) { 
                    // 若左指针指向的是有效元素则要进行-1操作
                    window.put(s.charAt(left), window.get(s.charAt(left)) - 1);
                    if (window.get(s.charAt(left)) < map.get(s.charAt(left))) {
                        valid++;
                    }
                }
                left++; // 滑动窗口收缩
            }
            right++; // 滑动窗口扩张
        }
        return res;
    }
}