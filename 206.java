// 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// 算法思想： 保存当前节点的下一个节点，再反向链接
class Solution {
    public ListNode reverseList(ListNode head) {
    	// 链表不带虚拟头节点
    	ListNode cur = head;
    	ListNode pre = null;
    	while(cur != null){
    		ListNode tmp = cur.next; // 保存当前节点的下一个节点防止丢失
    		cur.next = pre; // 反向链接
    		pre = cur;
    		cur = tmp; // 移动当前指针
    	}
    	return pre; // 返回反转后的头节点指针
    }
}

// 递归法
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(null, head);
    }

    // 基于递归的思想，将按照链表从后往前的顺序返回即反向
    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
        	return prev; 
        }
        ListNode temp = cur.next; // 保存下一个节点
        cur.next = prev; // 反向链接
        return reverse(cur, temp); // 当前节点是下一次迭代的prev，当前节点的下一个节点是下一次迭代的cur
    }
}