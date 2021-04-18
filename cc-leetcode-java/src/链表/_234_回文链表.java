package 链表;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 * @date   2021年2月6日 下午7:20:33
 * @author cc
 *
 */

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

public class _234_回文链表 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}
	
	public boolean isPalindrome(ListNode head) {
		ListNode newHead = head;
		List<Integer> list = new ArrayList<Integer>();
		// 把链表元素存入数组
		while(newHead != null) {
			list.add(newHead.val);
			newHead = newHead.next;
		}
		
		// 双指针判断是否回文
		int front = 0;
		int back = list.size() - 1;
		while (front < back) {
			if(!list.get(front).equals(list.get(back))) {
				return false;
			}
			front++;
			back--;
		}
		
		return true;
	}
	
}
