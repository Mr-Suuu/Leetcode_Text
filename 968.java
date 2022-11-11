// 给定一个二叉树，我们在树的节点上安装摄像头。

// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

// 计算监控树的所有节点所需的最小摄像头数量。

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

// 算法思想：基于后序遍历的思想，从最下层开始向上判断是否需要摄像头
class Solution {
    int count = 0;
    public int minCameraCover(TreeNode root) {
        if (minCame(root) == 0){
            count++; // 当是根节点且无覆盖的时候，摄像头数量+1
        }
        return count;
    }

    /**
     节点的状态值：
     0 表示无覆盖
     1 表示 有摄像头
     2 表示有覆盖
     后序遍历，根据左右节点的情况,来判读 自己的状态
     */
    public int minCame(TreeNode root){
        if (root == null){
            // 空节点默认为 有覆盖状态，避免在叶子节点上放摄像头 
            return 2;
        }
        int left = minCame(root.left);
        int right = minCame(root.right);
        if (left == 2 && right == 2){
            // 左右不是摄像头，但有覆盖
            return 0; //当前节点无覆盖
        }else if (left == 0 || right == 0){
            // 左右其中一个无覆盖
            count++; // 摄像头数量+1
            return 1; // 给当前节点增加摄像头
        }else {
            // 左右至少有一个摄像头，(1,1) (1,2) (2,1)
            return 2; // 当前节点不需要摄像头，有覆盖
        }
    }
}