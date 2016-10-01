package com.interviewbit.linkedlist;

public class RemoveNthNodeFromEndOfList {
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

		ListNode head = removeNthFromEnd(l1, 6);
		System.out.println();
	}

	static public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;

		ListNode fast = head;
		ListNode slow = head;

		for (int i = 0; i < n; i++) {
			if (fast == null)
				break;
			fast = fast.next;
		}

		// if remove the first node
		if (fast == null) {
			head = head.next;
			return head;
		}

		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		slow.next = slow.next.next;

		return head;
	}
}
