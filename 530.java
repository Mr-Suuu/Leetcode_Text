// 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

// 差值是一个正数，其数值等于两值之差的绝对值。

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
 
// 算法思想：基于中序遍历，计算前后两个数的差值，记录最小值
class Solution {
    TreeNode pre;
    int result = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
        traversal(root);
        return result;
    }

    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        // 中序遍历：左中右
        traversal(root.left);
        if (pre != null){
            result = Math.min(result, root.val - pre.val);
        }
        pre = root;
        traversal(root.right);
    }
}

// 算法思想：迭代法实现中序遍历
class Solution {
    public int getMinimumDifference(TreeNode root) {
        if (root == null){
            return 0;
        }
        TreeNode pre = null;
        int result = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            // 先将左节点全部入栈
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.pop();
                if (pre != null){
                    result = Math.min(result, cur.val - pre.val);
                }
                pre = cur;
                cur = cur.right;
            }
        }
        return result;
    }
}