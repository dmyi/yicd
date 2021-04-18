package 链表;

public class _206_反转链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("hello");
	}
	
	public ListNode reverseList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
    }
	
}
