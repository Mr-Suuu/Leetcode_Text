// 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

// 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。

// 算法思想：将每个单词内的字母排序后作为字典的键，原单词作作为值
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String str : strs){
            char[] array = str.toCharArray(); //将字符串转变为字符数组
            Arrays.sort(array); // 将原字符串排序
            String key = new String(array); //排序后的字符串作为键
            // getOrDefault 获得键对应的值，若没有则返回指定的默认值new ArrayList<String>()
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str); // 向值列表中加入新的值
            map.put(key, list); //更新键值对
        }
        // 取出值并返回值列表
        return new ArrayList<List<String>>(map.values());
    }
}