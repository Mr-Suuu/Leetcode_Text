// 给定二叉树的根节点 root ，返回所有左叶子之和。

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

// 算法思想：基于后序遍历，判断是否是左叶子
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}

    	int leftSum = sumOfLeftLeaves(root.left);
    	int rightSum = sumOfLeftLeaves(root.right);

    	// 若是左叶子则求和
    	if (root.left != null && root.left.left == null && root.left.right == null) {
    		return root.left.val + leftSum + rightSum;
    	}else {
    		return leftSum + rightSum;
    	}
    }
}

// 算法思想：基于迭代法，使用层次遍历法
class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            while (len > 0){
                TreeNode tempNode = queue.poll();
                if (tempNode.left != null){
                    queue.offer(tempNode.left);
                    if (tempNode.left.left == null && tempNode.left.right == null){
                        sum += tempNode.left.val;
                    }
                }
                if (tempNode.right != null){
                    queue.offer(tempNode.right);
                }
                len--;
            }
        }
        return sum;
    }
}