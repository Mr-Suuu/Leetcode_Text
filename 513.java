// 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。

// 假设二叉树中至少有一个节点。

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

// 算法思想：基于层次遍历的思想，找到最后一行第一个元素
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root.val;
        }
        int leftValue = root.val;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            int first = 1;
            while (len > 0){
                TreeNode tempNode = queue.poll();
                if (first == 1){
                    leftValue = tempNode.val;
                    first = 0;
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
        return leftValue;
    }
}

// 算法思想：基于递归的思想，使用前序遍历，即可优先遍历到一层中的最左边节点
class Solution {
    private int Deep = -1;
    private int value = 0;
    public int findBottomLeftValue(TreeNode root) {
        value = root.val;
        findLeftValue(root, 0);
        return value;
    }

    private void findLeftValue(TreeNode node, int deep) {
        if (node == null){
            return;
        }
        if (node.left == null && node.right == null){
            // 若是叶子节点则判断是否是这一层第一次搜索到的节点，第一次搜索到的即为最左边的节点
            if (deep > Deep){
                value = node.val;
                Deep = deep;
            }
        }
        if (node.left != null){
            findLeftValue(node.left, deep + 1);
        }
        if (node.right != null){
            findLeftValue(node.right, deep + 1);
        }
    }
}