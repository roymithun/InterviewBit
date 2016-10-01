package com.interviewbit.linkedlist;

public class ReverseLinkedListII {

	public static void main(String[] args) {
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l3;

		reverseBetween(l1, 2, 4);
		System.out.println();
	}

	static public ListNode reverseBetween(ListNode head, int m, int n) {
		if (m == n)
			return head;

		ListNode prev = null;// track (m-1)th node
		ListNode first = new ListNode(0);// first's next points to mth
		ListNode second = new ListNode(0);// second's next points to (n+1)th

		int i = 0;
		ListNode p = head;
		while (p != null) {
			i++;
			if (i == m - 1) {
				prev = p;
			}

			if (i == m) {
				first.next = p;
			}

			if (i == n) {
				second.next = p.next;
				p.next = null;
			}

			p = p.next;
		}
		if (first.next == null)
			return head;

		// reverse list [m, n]
		ListNode p1 = first.next;
		ListNode p2 = p1.next;
		p1.next = second.next;

		while (p1 != null && p2 != null) {
			ListNode t = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = t;
		}

		// connect to previous part
		if (prev != null)
			prev.next = p1;
		else
			return p1;

		return head;
	}
}
