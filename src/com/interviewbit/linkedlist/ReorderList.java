package com.interviewbit.linkedlist;

public class ReorderList {

	public static void main(String[] args) {
//		ListNode l8 = new ListNode(8);
//		ListNode l7 = new ListNode(7);
//		ListNode l6 = new ListNode(6);
//		ListNode l5 = new ListNode(5);
//		ListNode l4 = new ListNode(4);
//		ListNode l3 = new ListNode(3);
//		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);
		
//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
//		l6.next = l7;
//		l7.next = l8;
		
		reorderList(l1);
	}

	static public ListNode reorderList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode fast = head;
		ListNode slow = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode secondHead = slow.next;
		slow.next = null;

		ListNode p1 = secondHead;
		ListNode p2 = p1.next;

		while (p1 != null && p2 != null) {
			ListNode temp = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = temp;
		}
		secondHead.next = null;

		ListNode p = (p2 == null ? p1 : p2);
		ListNode q = head;

		while (p != null) {
			ListNode temp = p.next;
			p.next = q.next;
			q.next = p;
			p = temp;
			q = q.next.next;
		}
		return q;
	}
}
