// 给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。

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

// 算法思想：
class Solution {
    public ListNode swapPairs(ListNode head) {
    	ListNode dummyHead  = new ListNode(0);
    	dummyHead.next = head; // 构建虚拟头节点
    	ListNode prev = dummyHead;
    	while(prev.next != null && prev.next.next != null){
    		ListNode temp = head.next.next; // 保存下一次要用到的节点
    		// 接下来三步进行节点交换操作
    		prev.next = head.next;
    		head.next.next = head;
    		head.next = temp;
    		// 更新各节点信息
    		prev = head;
    		head = head.next;
    	}
    	return dummyHead.next;
    }
}