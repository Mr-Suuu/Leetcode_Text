// 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。

// 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2h 个节点。

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

// 算法思想：基于层次遍历，数有多少个节点（效率较低）
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null){
            return 0;
        }
        int nums = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int len = queue.size();
            nums += len;
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
        return nums;
    }
}

// 算法思想：利用完全二叉树的特性，找到左右子树中的满二叉树利用公式直接求数量
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nums = 0;
        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        if (leftDepth == rightDepth){
            // 此时左子树必为满二叉树
            // 因此左子树可用公式计算个数，右子树递归求解
            // 1 << X 表示2的X次方
            return (1 << leftDepth) + countNodes(root.right);
        }else {
            // 若两边不等高则右子树必为满二叉树
            return (1 << rightDepth) + countNodes(root.left);
        }
    }

    private int getDepth(TreeNode node) {
        if (node == null){
            return 0;
        }
        int left = getDepth(node.left);
        int right = getDepth(node.right);
        return left > right ? left + 1 : right + 1;
    }
}