// 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。

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


class Solution {
    List<Integer> resList = new LinkedList<>();
    public List<Integer> largestValues(TreeNode root) {
        findMax(root);
        return resList;
    }

    private void findMax(TreeNode node) {
        if (node == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            int max = Integer.MIN_VALUE;
            int len = queue.size();
            while (len > 0){
                TreeNode tempNode = queue.poll();
                if (tempNode.val > max){
                    max = tempNode.val;
                }
                if (tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null){
                    queue.offer(tempNode.right);
                }
                len--;
            }
            resList.add(max);
        }
    }
}