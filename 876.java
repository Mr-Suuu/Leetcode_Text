// 给定一个头结点为 head 的非空单链表，返回链表的中间结点。

// 如果有两个中间结点，则返回第二个中间结点。

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

// 算法思想：先遍历一次看有几个元素，然后找到中间位置返回
class Solution {
    public ListNode middleNode(ListNode head) {
        int num = 0;
        ListNode cur = head;
        while (cur != null) {
            ++num;
            cur = cur.next;
        }
        int k = 0;
        cur = head;
        while (k < num / 2) {
            ++k;
            cur = cur.next;
        }
        return cur;
    }
}

// 算法思想：快慢指针法，快指针每次走两步，慢指针每次走一步，当快指针走到null时即返回慢指针
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
        	fast = fast.next.next;
        	slow = slow.next;
        }
        return slow;
    }
}