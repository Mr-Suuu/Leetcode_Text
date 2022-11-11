// 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// 算法思想：先求出AB的长度，然后将长的后移至等长位置，然后开始逐个比较
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0;
        int lenB = 0;
        while (curA != null){
            lenA++;
            curA = curA.next;
        }
        while (curB != null){
            lenB++;
            curB = curB.next;
        }
        ListNode slow, fast;
        int gap;
        if (lenA >= lenB){
            fast = headA;
            slow = headB;
            gap = lenA - lenB;
        }else {
            fast = headB;
            slow = headA;
            gap = lenB - lenA;
        }
        while (gap-- > 0){
            fast = fast.next;
        }
        while (fast != null){
            if (fast == slow){
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return null;
    }
}