package com.interviewbit.linkedlist;

public class MergeTwoSortedLists {

	public static void main(String[] args) {
		ListNode l5 = new ListNode(10);
		ListNode l4 = new ListNode(8);
		ListNode l3 = new ListNode(6);
		ListNode l2 = new ListNode(5);
		ListNode l1 = new ListNode(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		ListNode r3 = new ListNode(9);
		ListNode r2 = new ListNode(4);
		ListNode r1 = new ListNode(2);

		r1.next = r2;
		r2.next = r3;
		
		mergeTwoLists(l1, r1);
	}

	static public ListNode mergeTwoLists(ListNode a, ListNode b) {

		ListNode p1 = a;
		ListNode p2 = b;

		ListNode fakeHead = new ListNode(0);
		ListNode p = fakeHead;

		while (p1 != null && p2 != null) {
			if (p1.val <= p2.val) {
				p.next = p1;
				p1 = p1.next;
			} else {
				p.next = p2;
				p2 = p2.next;
			}

			p = p.next;
		}

		if (p1 != null)
			p.next = p1;
		if (p2 != null)
			p.next = p2;

		return fakeHead.next;
	}
}
