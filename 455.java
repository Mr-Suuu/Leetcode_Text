// 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。

// 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

// 算法思想：基于贪心算法思想，优先用小尺寸饼干喂饱小胃口的小孩
class Solution {
    // g是小孩，s是饼干
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0; // 记录喂饱了几个小孩
        int start = 0; // 标记饼干开始的下标
        for (int i = 0; i < s.length && start < g.length; i++) {
            if (g[start] <= s[i]){
                start++;
                count++;
            }
        }
        return count;
    }
}