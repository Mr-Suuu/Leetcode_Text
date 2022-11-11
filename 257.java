// 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。

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

// 算法思想：基于先序遍历及回溯的思想
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> resList = new LinkedList<>();
        if (root == null) {
            return resList;
        }
        List<Integer> paths = new LinkedList<>();
        traversal(root, paths, resList);
        return resList;
    }

    private void traversal(TreeNode node, List<Integer> paths, List<String> res) {
        // 若是叶子节点，则将该路径保存到结果中
        paths.add(node.val); // 首先将节点入队
        if (node.left == null && node.right == null) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < paths.size() - 1; i++) {
                str.append(paths.get(i)).append("->");
            }
            str.append((paths.get(paths.size() - 1))); // 将最后一个节点放入，最后不用加"->"
            res.add(str.toString()); // 将该路径加入结果列表中
            return;
        }
        if (node.left != null) {
            traversal(node.left, paths, res);
            paths.remove(paths.size() - 1); // 遍历完基于该节点的路径后就退出并把该节点从路径中删除，这是基于回溯的思想
        }
        if (node.right != null) {
            traversal(node.right, paths, res);
            paths.remove(paths.size() - 1); // 同上面的思想
        }
    }
}