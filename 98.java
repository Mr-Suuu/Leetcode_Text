// 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。

// 有效 二叉搜索树定义如下：

// 节点的左子树只包含 小于 当前节点的数。
// 节点的右子树只包含 大于 当前节点的数。
// 所有左子树和右子树自身必须也是二叉搜索树

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

 // 算法思想：使用中序遍历，二叉搜索树的中序遍历为升序序列，因此可以判断后一个数是否比前一个大，若不是则不为二叉搜索树
class Solution {
    TreeNode max = null;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        // 中序遍历
        boolean left = isValidBST(root.left);
        if (!left){
            return false;
        }
        if (max != null && root.val <= max.val){
            return false;
        }
        max = root;
        boolean right = isValidBST(root.right);
        return right;
    }
}

// 算法思想：基于栈实现
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        while (root != null || !stack.isEmpty()){
            // 先将当前节点的左节点全部入栈
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            TreeNode curNode = stack.pop();
            if (preNode != null && curNode.val <= preNode.val){
                return false;
            }
            preNode = curNode;
            // 遍历完左、中就开始遍历右
            root = curNode.right;
        }
        return true;
    }
}