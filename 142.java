// 给定一个链表的头节点head，返回链表开始入环的第一个节点。如果链表无环，则返回null。

// 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。

// 不允许修改 链表。

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// 算法思想：使用快慢指针法，分别定义 fast 和 slow 指针，从头结点出发，fast指针每次移动两个节点，slow指针每次移动一个节点，如果 fast 和 slow指针在途中相遇 ，说明这个链表有环
//          从头结点出发一个指针，从相遇节点 也出发一个指针，这两个指针每次只走一个节点， 那么当这两个指针相遇的时候就是 环形入口的节点。
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
        	fast = fast.next.next; // 快指针移动两次
        	slow = slow.next; // 慢指针只移动一次
        	if (fast == slow) { //有环
        		ListNode index1 = fast; // 从碰撞位置开始出发一个指针
        		ListNode index2 = head; // 从头位置出发一个指针
        		while(index1 != index2){
        			index1 = index1.next;
        			index2 = index2.next;
        		}
        		return index1;
        	} 
        }
        return null;
    }
}