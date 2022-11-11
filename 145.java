// 给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。

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

// 后序遍历思想：基于递归的思想
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    void postorder(TreeNode root, List<Integer> result){
        if (root == null) {
            return;
        }
        // 后序遍历：左右根
        postorder(root.left, result);
        postorder(root.right, result);
        result.add(root.val);
    }

}

// 基于迭代的思想：先基于栈完成，后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.left != null){
                stack.push(node.left);
            }
            if (node.right != null){
                stack.push(node.right);
            }
        }
        // 将出栈结果反转即为后序遍历结果
        Collections.reverse(result);
        return result;
    }
}