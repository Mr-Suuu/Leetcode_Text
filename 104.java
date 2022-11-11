// 给定一个二叉树，找出其最大深度。

// 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。

// 说明: 叶子节点是指没有子节点的节点。

// 示例：
// 给定二叉树 [3,9,20,null,null,15,7]，

//     3
//    / \
//   9  20
//     /  \
//    15   7
// 返回它的最大深度 3 。
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

// 算法思想：基于层次遍历，数有多少层
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        int dep = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            dep++;
            int len = queue.size();
            while (len > 0){
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null){
                    queue.offer(tempNode.left);
                }
                if (tempNode.right != null){
                    queue.offer(tempNode.right);
                }
                len--;
            }
        }
        return dep;
    }
}


// 算法思想：基于递归的思想，先求它的左子树的深度，再求的右子树的深度，最后取左右深度最大的数值 再+1 （加1是因为算上当前中间节点）就是目前节点为根节点的树的深度
class Solution {
    public int maxDepth(TreeNode root) {
        return getdepth(root);
    }

    private int getdepth(TreeNode node){
      if (node == null) {
        return 0;
      }
      int leftDepth = getdepth(node.left);
      int rightDepth = getdepth(node.right);
      return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }
}
