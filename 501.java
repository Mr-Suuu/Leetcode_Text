// 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。

// 如果树中有不止一个众数，可以按 任意顺序 返回。

// 假定 BST 满足如下定义：

// 结点左子树中所含节点的值 小于等于 当前节点的值
// 结点右子树中所含节点的值 大于等于 当前节点的值
// 左子树和右子树都是二叉搜索树


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

// 算法思想：基于中序遍历和递归
class Solution {
    List<Integer> resList = new ArrayList<>();
    int maxCount;
    int count;
    TreeNode pre;
    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        maxCount = 0;
        count = 0;
        pre = null;
        findMode1(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }
    
    // 算法思想：基于中序遍历
    private void findMode1(TreeNode node) {
        if (node == null) {
            return;
        }
        findMode1(node.left);

        int rootValue = node.val;
        // 判断是否是第一个数，若不是则是否与前一个数相同，若是则将计数器重置为1
        if (pre == null || rootValue != pre.val){
            count = 1; 
        }else {
            // 若是同一个数则计数器+1
            count++;
        }
        // 更新计数器结果以及maxCount
        if (count > maxCount){
            // 若计数器大于maxCount，则先清空结果列表并加入新的值
            resList.clear();
            resList.add(rootValue);
            maxCount = count;
        }else if (count == maxCount){
            // 若出现频率相同则加入结果列表中
            resList.add(rootValue);
        }
        // 更新前驱节点
        pre = node;
        
        findMode1(node.right);
    }
}


// 算法思想：基于中序遍历和迭代法
class Solution {
    public int[] findMode(TreeNode root) {
        TreeNode pre = null;
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        int maxCount = 0;
        int count = 0;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            // 若是左节点则继续入栈
            if (cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                // 直到左节点为空出栈
                cur = stack.pop();
                if (pre == null || cur.val != pre.val){
                    // 若是第一次出现，则将计数器置为1
                    count = 1;
                }else {
                    // 若是重复的则计数器+1
                    count++;
                }
                if (count > maxCount){
                    maxCount = count;
                    result.clear();
                    result.add(cur.val);
                }else if (count == maxCount){
                    result.add(cur.val);
                }
                // 向右子树走
                pre = cur;
                cur = cur.right;
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}