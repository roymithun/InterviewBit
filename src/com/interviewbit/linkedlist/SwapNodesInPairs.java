package com.interviewbit.linkedlist;

public class SwapNodesInPairs {

	public static void main(String[] args) {
		ListNode l8 = new ListNode(8);
		ListNode l7 = new ListNode(7);
		ListNode l6 = new ListNode(6);
		ListNode l5 = new ListNode(5);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;

		swapPairs(l1);
		System.out.println();
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/SwapNodesinPairs.java
	static public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = dummy;
		while (cur.next != null && cur.next.next != null) {
			ListNode node = cur.next.next;
			cur.next.next = node.next;
			node.next = cur.next;
			cur.next = node;
			cur = node.next;
		}
		return dummy.next;
	}
}
