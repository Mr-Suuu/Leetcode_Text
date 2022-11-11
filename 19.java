// 给你一个链表，删除链表的倒数第n个结点，并且返回链表的头结点。

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

// 算法思想：使用快慢指针，fast先向前走n+1步，然后一起后移，当fast到尾部即可删除slow的下一个指针
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(-1); // 构建虚拟头节点
        dummyHead.next = head;
        ListNode slow = dummyHead;
        ListNode fast = dummyHead;
        // fast向后移动n+1步
        while(n-- >= 0){
            fast = fast.next;
        }
        while(fast != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next; // 删除节点
        return dummyHead.next;
    }
}