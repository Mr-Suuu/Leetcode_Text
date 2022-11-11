// 给定一个二叉树，找出其最小深度。

// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。

// 说明：叶子节点是指没有子节点的节点。

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

// 基于层次遍历
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int mindep = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            mindep++;
            int len = queue.size();
            while (len > 0){
                TreeNode tempNode = queue.poll();
                if (tempNode.left == null && tempNode.right == null){
                    // 只有当该节点的左右孩子均为空才直接返回最小深度
                    return mindep;
                }
                if (tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null){
                    queue.offer(tempNode.right);
                }
                len--;
            }
        }
        return mindep;
    }
}

// 基于递归的思想
class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        // 若某一边为空，则返回另一边的高度+1
        if (root.left == null) {
            return rightDepth + 1;
        }
        if (root.right == null) {
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}