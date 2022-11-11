// 小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为 root 。

// 除了 root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的房子在同一天晚上被打劫 ，房屋将自动报警。

// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

// 算法思想：使用后序遍历遍历二叉树，dp数组设置两位，0代表不偷该节点，1代表偷该节点 
class Solution {
    public int rob(TreeNode root) {
        int[] res = robAction(root); // 数组中0下标表示不偷，1下标表示偷
        return Math.max(res[0], res[1]);
    }

    private int[] robAction(TreeNode node) {
        int[] dp = new int[2]; // 数组中0下标表示不偷，1下标表示偷
        if (node == null){
            return dp;
        }
        // 使用后序遍历
        int[] left = robAction(node.left);
        int[] right = robAction(node.right);
        // 不偷的情况
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 偷的情况
        dp[1] = node.val + left[0] + right[0];
        return dp;
    }
}