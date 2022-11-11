// 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。

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
    public List<List<Integer>> resList = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        checkFun02(root);
        return  resList;
    }

    // 迭代法：基于队列实现
    public void checkFun02(TreeNode node){
        if (node == null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(node);
        while (!queue.isEmpty()){
            // 用于存储当前这一层的元素信息
            List<Integer>  itemList = new ArrayList<Integer>();
            int len = queue.size(); // 表示这一层有几个元素

            while (len > 0){
                TreeNode tempNode = queue.poll();
                itemList.add((tempNode.val));

                if (tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.offer(tempNode.right);
                }
                len--;
            }
            resList.add(itemList); // 将这一层信息保存到结果列表中
        }
    }
}