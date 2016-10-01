package com.interviewbit.linkedlist;

public class ListCycle {

	public static void main(String[] args) {
		ListNode l5 = new ListNode(1);
		ListNode l4 = new ListNode(2);
		ListNode l3 = new ListNode(5);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l3;

		System.out.println(detectCycle(l1));
	}

	static public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;

		ListNode slow = head.next;
		ListNode fast = head.next.next;

		while (fast != null) {
			if (slow == fast)
				return true;

			slow = slow.next;
			fast = fast.next;
			if (fast != null)
				fast = fast.next;
		}

		return false;
	}

	static public ListNode detectCycle(ListNode head) {
		if (head == null || head.next == null)
			return null;
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow == fast)
				break;
		}
		if (fast == null || fast.next == null)
			return null;
		slow = head;
		while (slow != fast) {
			slow = slow.next;
			fast = fast.next;
		}
		return slow;
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}
}
