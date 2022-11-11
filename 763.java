// 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。

// 算法思想：首先记录每个字母最后出现的位置，然后找到下标与最大右边界相同的节点进行切分
class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] hash = new int[26];
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            // 记录最后出现的下标位置
            hash[s.charAt(i) - 'a'] = i;
        }
        int left = -1;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(right, hash[s.charAt(i) - 'a']); // 更新最大右边界
            if (i == right){
                // 若当前是片段最后位置
                result.add(i - left);
                left = i;
            }
        }
        return result;
    }
}