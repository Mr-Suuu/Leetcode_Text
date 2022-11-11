// 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。

// 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。

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

// 算法思想：遍历二叉搜索树，找到空节点插入元素
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        TreeNode curNode = root;
        while (curNode != null){
            if (curNode.val > val){
                // 若左节点不为空则向左孩子移动，否则插入左节点
                if (curNode.left != null){
                    curNode = curNode.left;
                }else {
                    curNode.left = new TreeNode(val);
                }
            }
            if (curNode.val < val){
                if (curNode.right != null){
                    curNode = curNode.right;
                }else {
                    curNode.right = new TreeNode(val);
                }
            }
        }
        return root;
    }
}

// 递归
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null){
            return new TreeNode(val);
        }
        if (root.val < val){
            root.right = insertIntoBST(root.right, val); // 递归在右子树中查找插入位置
        }
        if (root.val > val){
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
