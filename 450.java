// 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。

// 一般来说，删除节点可分为两个步骤：

// 首先找到需要删除的节点；
// 如果找到了，删除它。

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

// 算法思想：通过遍历找到要删除的节点并根据节点情况删除
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        root = delete(root,key);
        return root;
    }

    private TreeNode delete(TreeNode node, int key) {
        if (node == null){
            return null;
        }
        if (node.val > key){
            node.left = delete(node.left, key);
        }else if (node.val < key){
            node.right = delete(node.right, key);
        }else{
            if (node.left == null){
                return node.right;
            }
            if (node.right == null){
                return node.left;
            }
            // 若左右子树都存在，则将左子树插入到右子树的最左下节点的左子树中
            TreeNode tempNode = node.right;
            while (tempNode.left != null){
                // 找到最左下节点
                tempNode = tempNode.left;
            }
            tempNode.left = node.left; // 将左子树移动到右子树最左下位置
            node = node.right; // 将当前节点删除并将当前节点的右子树替换
//            node.val = tempNode.val;
//            node.right = delete(node.right, tempNode.val);
        }
        return node;
    }
}