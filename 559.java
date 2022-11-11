// 给定一个 N 叉树，找到其最大深度。

// 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。

// N 叉树输入按层序遍历序列化表示，每组子节点由空值分隔（请参见示例）。

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// 算法思想：基于层次遍历的思想，
class Solution {
    public int maxDepth(Node root) {
        if (root == null){
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int dep = 0;
        while (!queue.isEmpty()){
            dep++;
            int len = queue.size();
            while (len > 0){
                Node tempNode = queue.poll();
                for (Node node : tempNode.children){
                    if (node != null){
                        queue.offer(node);
                    }
                }
                len--;
            }
        }
        return dep;
    }
}

// 算法思想：基于递归的思想，使用后序遍历求最大深度
class Solution {
    /*递归法，后序遍历求root节点的高度*/
    public int maxDepth(Node root) {
    	if (root == null) {
    		return 0;
    	}

    	int depth = 0;
    	if (root.children != null) {
    		for (Node node : root.children) {
    			depth = Math.max(depth, maxDepth(node));
    		}
    	}
    	return depth + 1;
    }
}