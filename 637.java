// 给定一个非空二叉树的根节点 root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10-5 以内的答案可以被接受。



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
    List<Double> resList = new ArrayList<>();
    public List<Double> averageOfLevels(TreeNode root) {
        averageCount(root);
        return resList;
    }

    private void averageCount(TreeNode node) {
        if (node == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            double sum = 0;
            int len = queue.size();
            int size = queue.size();
            while (len > 0){
                TreeNode tempNode = queue.poll();
                sum += tempNode.val;
                if (tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null){
                    queue.offer(tempNode.right);
                }
                len--;
            }
            resList.add(sum / size);
        }
    }
}