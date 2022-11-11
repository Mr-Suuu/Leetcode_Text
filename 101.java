// 给你一个二叉树的根节点 root ， 检查它是否轴对称。

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

// 算法思想：对于一个节点，首先比较其外侧节点，在比较其内侧节点，然后返回比较结果，递归完成上述过程
class Solution {
    public boolean isSymmetric(TreeNode root) {
    	if (root == NULL){
    		return true;
    	}
        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
    	if (left == null && right != null) {
    		return false;
    	}else if (left != null && right == null) {
    		return false;
    	}else if (left == null && right == null) {
    		return true;
    	}else if (left != null && right != null && left.val != right.val) {
    		return false;
    	}else{
    		// 剩余情况都是满足左右相等的时候
    		// 若当前满足，则继续递归下一层
    		boolean compareOutside = compare(left.left, right.right); // 外侧
    		boolean compareInside  = compare(left.right, right.left); // 内侧
    		return compareOutside&&compareInside;
    	}
    }
}

// 算法思想：基于双端队列
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerFirst(root.left);
        deque.offerLast(root.right);
        while (!deque.isEmpty()){
            TreeNode left = deque.pollFirst();
            TreeNode right = deque.pollLast();
            // 首先将都为空的直接跳过
            if (left == null && right == null) {
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
            // 上述都不满足则当前位置符合对称要求
            // 外侧元素先入双端队列
            deque.offerFirst(left.left);
            deque.offerFirst(left.right);
            deque.offerLast(right.right);
            deque.offerLast(right.left);
        }
        return true;
    }
}

// 算法思想：基于普通队列
public boolean isSymmetric3(TreeNode root) {
    Queue<TreeNode> deque = new LinkedList<>();
    deque.offer(root.left);
    deque.offer(root.right);
    while (!deque.isEmpty()) {
        TreeNode leftNode = deque.poll();
        TreeNode rightNode = deque.poll();
        if (leftNode == null && rightNode == null) {
            continue;
        }
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;
        }
        // 这里顺序与使用Deque不同，先外侧入队，再内侧入队
        deque.offer(leftNode.left);
        deque.offer(rightNode.right);
        deque.offer(leftNode.right);
        deque.offer(rightNode.left);
    }
    return true;
}