// 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。

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

// 算法思想：
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1); //下标是左闭右开
    }

    private TreeNode buildTree1(int[] preorder, int preLeft, int preRight,
                                int[] inorder, int inLeft, int inRight) {
        if (inLeft > inRight || preLeft > preRight){
            return null;
        } 

        // 前序序列中第一个元素即为根节点
        int rootVal = preorder[preLeft];
        TreeNode root = new TreeNode(rootVal);
        // 找到在中序序列中根节点的下标
        int rootIndex = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == rootVal){
                rootIndex = i;
                break;
            }
        }
        root.left = buildTree1(preorder, preLeft + 1, preLeft + (rootIndex - inLeft),
                inorder, inLeft, rootIndex - 1);
        root.right = buildTree1(preorder, preLeft + (rootIndex - inLeft) + 1, preRight,
                inorder, rootIndex + 1, inRight);
        return root;
    }
}