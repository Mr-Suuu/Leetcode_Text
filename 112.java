// 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。

// 叶子节点 是指没有子节点的节点。


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

// 算法思想：使用先序遍历，每次计算一条路径上的和，与目标值进行判断
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        targetSum -= root.val;
        if (root.left == null && root.right == null){
            // 若是叶子节点则判断路径和是否一致
            return targetSum == 0;
        }
        if (root.left != null){
            boolean left = hasPathSum(root.left, targetSum);
            if (left){
                // 若在左子树中找到路径则返回true
                return true;
            }
        }
        if (root.right != null){
            boolean right = hasPathSum(root.right, targetSum);
            if (right){
                // 若在右子树中找到路径则返回true
                return true;
            }
        }
        return false;
    }
}

// 算法思想：基于迭代的思想，用两个栈完成操作
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        Stack<TreeNode> stack1 = new Stack<>(); // 记录节点
        Stack<Integer> stack2 = new Stack<>(); // 记录路径和
        stack1.push(root);
        stack2.push(root.val);
        while (!stack1.isEmpty()){
            int len = stack1.size();
            for (int i = 0; i < len; i++){
                TreeNode node = stack1.pop();
                int sum = stack2.pop(); // 获取当前路径的和
                if (node.left == null && node.right == null && sum == targetSum){
                    // 若是叶子节点且路径和一致则返回true
                    return true;
                }
                // 若左右节点不为空则入栈
                if (node.right != null){
                    stack1.push(node.right);
                    stack2.push(sum + node.right.val);
                }
                if (node.left != null){
                    stack1.push(node.left);
                    stack2.push(sum + node.left.val);
                }
            }
        }
        return false;
    }
}