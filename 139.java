// 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。

// 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。

// 算法思想：基于完全背包的思想，将字典作为物品，一个单词可以重复出现即有无数件物品即为完全背包问题，字符串作为背包进行判断
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] valid = new boolean[s.length()+1];
        valid[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (wordDict.contains(s.substring(j, i)) && valid[j]){
                    // 若字典中包含截取字符串并且前j位都是分割子串，则第j-i位也是分割字串即0-j-i都是分割子串
                    valid[i] = true;
                }
            }
        }
        return valid[s.length()];
    }
}