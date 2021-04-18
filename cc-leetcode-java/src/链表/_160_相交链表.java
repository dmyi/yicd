package 链表;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * @date   2020年11月8日 下午3:33:54
 * @author cc
 *
 */
//双指针的方式解决链表相交问题
public class _160_相交链表 {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		ListNode pA = headA;
		ListNode pB = headB;
		
		while (pA != pB) {
			if(pA != null) {
				pA = pA.next;
			} else {
				pA = headB;
			}
			
			if(pB != null) {
				pB = pB.next;
			} else {
				pB = headA;
			}		
		}
		
		return pA;
    }
	
}
