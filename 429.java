// 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。

// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。

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


class Solution {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        Func(root);
        return resList;
    }

    private void Func(Node node) {
        if (node == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            List<Integer> itemList = new LinkedList<>();
            int len = queue.size();
            while (len > 0){
                Node tempNode = queue.poll();
                itemList.add(tempNode.val);
                for (Node childNode : tempNode.children){
                    // 将孩子节点加入队列中
                    if (childNode != null){
                        queue.add(childNode);
                    }
                }
                len--;
            }
            resList.add(itemList);
        }
    }
}