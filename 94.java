// 给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。

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

// 中序遍历算法思想：基于递归的思想
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<>(); // 保存结果的列表
    	inorder(root, res);
    	return res;
    }

    void inorder(TreeNode root, List<Integer> list){
    	if (root == null) {
    		return;
    	}
    	// 中序遍历：左根右
    	inorder(root.left, list);
    	list.add(root.val); // 将当前节点加入列表中
    	inorder(root.right, list)l
    }
}

// 基于迭代的思想：
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>(); // 保存结果的列表
        if (root == null){
            return result;
        }
        // 定义一个节点指向当前待判断节点
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while (cur != null || !stack.isEmpty()){
            // 若当前节点不为空，则进行入栈操作并判断是否还有左孩子
            if (cur != null){
                stack.push(cur);
                cur = cur.left; // 先深度遍历左节点完成入栈操作
            }else {
                // 若左节点已全部遍历完
                cur = stack.pop(); // 弹出栈顶元素
                result.add(cur.val);
                cur = cur.right; // 开始遍历右节点
            }
        }
        return result;
    }
}