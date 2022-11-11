// 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

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

// 算法思想：基于层次遍历的思想，将每一层最后一个元素放入结果列表中
class Solution {
    List<Integer> resList = new LinkedList<>();
    public List<Integer> rightSideView(TreeNode root) {
        findRight(root);
        return resList;
    }

    private void findRight(TreeNode node) {
        if (node == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        while (!queue.isEmpty()){
            List<Integer>  itemList = new ArrayList<Integer>();
            int len = queue.size(); // 获取该层元素个数
            while (len > 0){
                TreeNode tempNode = queue.poll();
                if (len == 1){
                    // 该层最后一个元素放入结果列表中
                    resList.add(tempNode.val);
                }
                if (tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
                len--;
            }
        }
    }
}