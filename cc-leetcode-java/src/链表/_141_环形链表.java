package 链表;

/**
 * https://leetcode-cn.com/problems/linked-list-cycle/
 * @date   2021年2月10日 上午7:24:14
 * @author cc
 *
 */
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

public class _141_环形链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean hasCycle(ListNode head) {
        ListNode dhead = new ListNode(-1);
        dhead.next = head;
        ListNode l1 = dhead;
        ListNode l2 = dhead;
        
        while (true) {
			if(l2.next == null || l2.next.next == null) {
				return false;
			}
			l1 = l1.next;
			l2 = l2.next.next;
			if(l1 == l2) {
				return true;
			}			
		}
    }

}
