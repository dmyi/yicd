package 链表;

public class _19_删除链表的倒数第N个结点 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode dhead = new ListNode(-1);
		dhead.next = head;
		
		int count = 0; // 链表的节点数量	
		for(ListNode cur = dhead; cur.next != null; cur = cur.next) {
			count++;
		}
		
		int index = count - n;
		ListNode cur = dhead;
		while (index != 0) {
			index--;
			cur = cur.next;
		}
		cur.next = cur.next.next;

		return dhead.next;
    }

}
