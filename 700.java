// 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。

// 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。

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

// 算法思想：与当前节点进行比较，若大于则往左子树走，反之则往右子树走
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return searchFunc(root, val);
    }

    private TreeNode searchFunc(TreeNode node, int val){
        if (node == null){
            return null;
        }
        if (node.val == val){
            return node;
        }else if (node.val > val){
            return searchFunc(node.left, val);
        }else{
            return searchBST(node.right, val);
        }
    }
}

// 算法思想：基于迭代的思想
class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        return searchFunc(root, val);
    }

    private TreeNode searchFunc(TreeNode node, int val){
        while (node != null){
            if (node.val == val){
                return node;
            }else if (node.val > val){
                node = node.left;
            }else {
                node = node.right;
            }
        }
        return null;
    }
}