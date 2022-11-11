// 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 算法思想：基于后序遍历，实现回溯
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 若是空节点或目标节点则直接返回
        if (root == null || root == p || root == q){
            return root;
        }
        // 基于后续遍历实现回溯
        // 分别在左右子树中查找，再判断当前节点
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null){
            // 若左右都找不到则直接返回null
            return null;
        }else if (left != null && right != null){
            // 若左右都不为空则代表p、q分别在左右子树中，则当前节点即为结果
            return root;
        }else{
            // 若其中一边不为空，则返回不为空的一边
            if (left != null){
                return left;
            }else {
                return right;
            }
        }
    }
}