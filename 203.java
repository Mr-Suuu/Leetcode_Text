// 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 
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

// 初始化一个新的空结点，值为0
// ListNode* Node = new ListNode(0);
class Solution {
    public ListNode removeElements(ListNode head, int val) {
    	ListNode* dummyHead  = new ListNode(0); // 初始化一个值为0的空结点
    	dummyHead.next = head; // dummyHead是虚拟头节点
    	ListNode temp = dummyHead; //构建临时指向的指针
    	while(temp.next != null){
    		if (temp.next.val == val) {
    			temp.next = temp.next.next; // 删除下一位置
    		}else {
    			temp = temp.next;
    		}
    	}
    	return dummyHead.next;
    }
}