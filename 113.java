// 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

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
// 算法思想：基于递归的思想，当遍历到符合题意的路径时加入结果列表中，递归下一层返回时要回溯，将下一层添加的路径删去
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> resList = new ArrayList<>();
        if (root == null){
            return resList;
        }
        List<Integer> path = new LinkedList<>();
        preorderdfs(root, targetSum, resList, path);
        return resList;
    }

    private void preorderdfs(TreeNode node, int targetSum, List<List<Integer>> resList, List<Integer> path){
        path.add(node.val); // 将当前节点值加入路径中
        if (node.left == null && node.right == null){
            if (targetSum - node.val == 0){
                resList.add(new ArrayList<>(path));
            }
            return; // 如果路径和不一致则直接返回
        }
        if (node.left != null){
            preorderdfs(node.left, targetSum - node.val, resList, path);
            path.remove(path.size() - 1); // 回溯，将上一行递归的值删去
        }
        if (node.right != null){
            preorderdfs(node.right, targetSum - node.val, resList, path);
            path.remove(path.size() - 1); //回溯
        }
    }
}