// 给定一个二叉树，判断它是否是高度平衡的二叉树。

// 本题中，一棵高度平衡二叉树定义为：

// 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

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

// 算法思想：求左右子树高度，相差大于一则不是平衡二叉树
class Solution {
    public boolean isBalanced(TreeNode root) {

    }

    private boolean getHeight(TreeNode node){
    	if (node == null) {
    		return 0;
    	}
    	int left = getHeight(node.left);
    	int right = getHeight(node.right);
    	return Math. ? left + 1 : right + 1;
    }
}