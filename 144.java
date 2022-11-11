// 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。


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

// 前序遍历算法思想：基于递归的思想
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    void preorder(TreeNode root, List<Integer> result){
        if (root == null) {
            return;
        }
        // 前序遍历：根左右
        result.add(root.val);
        preorder(root.left, result);
        preorder(root.right, result);
    }
}

// 基于迭代的思想：基于栈实现
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); // 根节点入栈
        // 先序遍历顺序：根左右
        while (!stack.isEmpty()){
            TreeNode node = stack.pop(); // 根节点出栈
            result.add(node.val);
            // 右节点先入栈，因为出栈是后进先出
            if (node.right != null){
                stack.push(node.right);
            }
            if (node.left != null){
                stack.push(node.left);
            }
        }
        return result;
    }
}