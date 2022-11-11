// 给定一个二叉树

// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

// 初始状态下，所有 next 指针都被设置为 NULL。
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null){
            return root;
        }
        Node cur = root;
        Node dummy = new Node(0); // 构建虚拟头节点
        while (cur != null){
            Node pre = dummy; // 前驱节点
            while (cur != null){
                // 若左右孩子节点存在则连接
                if (cur.left != null){
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null){
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next; // 因为遍历上一层时已把当前层next连接起来了，因此可以直接next
            }
            // 此时dummy指向下一层的最左边节点
            cur = dummy.next; // 将cur指向下一行的最左边元素
            dummy.next = null; // 重置虚拟头节点
        }
        return root;
    }
}