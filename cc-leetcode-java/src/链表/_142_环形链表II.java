package 链表;
/**
 * https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @date   2021年2月11日 上午6:42:45
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

public class _142_环形链表II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode detectCycle(ListNode head) {
       if(head == null) return null;
       
       ListNode l1 = head;
       ListNode l2 = head;
       
       while (true) {
    	   if(l2.next == null || l2.next.next == null) {
    		   return null;
    	   }
    	   l1 = l1.next;
    	   l2 = l2.next.next;
    	   if(l1 == l2) {
    		   break;
    	   }		
       }
       
       l1 = head;
       while(l1 != l2) {
    	   l1 = l1.next;
    	   l2 = l2.next;
       }  
       
       return l1;
    }

}
