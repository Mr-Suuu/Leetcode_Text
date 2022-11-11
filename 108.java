// 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

// 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。

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

// 算法思想：基于递归的思想，取中间位作为根节点进行划分
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length);
    }

    // 左闭右开
    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left >= right){
            return null;
        }

        if (right - left == 1){
            return new TreeNode(nums[left]);
        }

        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, left, mid);
        root.right = sortedArrayToBST(nums, mid + 1, right);
        return root;
    }
}

// 算法思想：基于迭代的思想，去中间位作为根节点进行划分
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0){
            return null;
        }

        //根节点初始化
        TreeNode root = new TreeNode(-1);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> leftQueue = new LinkedList<>();
        Queue<Integer> rightQueue = new LinkedList<>();

        // 根节点入队列
        nodeQueue.offer(root);
        // 0为左区间下标初始位置
        leftQueue.offer(0);
        // nums.size() - 1为右区间下标初始位置
        rightQueue.offer(nums.length - 1);

        while (!nodeQueue.isEmpty()){
            TreeNode curNode = nodeQueue.poll();
            int left = leftQueue.poll();
            int right = rightQueue.poll();
            int mid = left + ((right - left) >> 1);
            // 给当前节点赋值
            curNode.val = nums[mid];

            // 处理左区间
            if (left <= mid - 1){
                curNode.left = new TreeNode(-1);
                nodeQueue.offer(curNode.left);
                leftQueue.offer(left);
                rightQueue.offer(mid - 1);
            }

            // 处理右区间
            if (right >= mid + 1){
                curNode.right = new TreeNode(-1);
                nodeQueue.offer(curNode.right);
                leftQueue.offer(mid + 1);
                rightQueue.offer(right);
            }
        }
        return root;
    }
}