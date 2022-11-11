// 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。

// 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。

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

// 算法思想：与判断树是否对成思想相似，基于双端队列，一棵树在队头插入，另一棵树在队尾插入
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(p);
        deque.offerLast(q);
        while (!deque.isEmpty()){
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            // 若都为空则跳过本轮
            if (left == null && right == null){
                continue;
            }
            if (left == null && right != null){
                return false;
            }
            if (left != null && right == null){
                return false;
            }
            if (left.val != right.val){
                return false;
            }
            deque.offerFirst(left.left);
            deque.offerLast(right.left);
            deque.offerFirst(left.right);
            deque.offerLast(right.right);
        }
        return true;
    }
}