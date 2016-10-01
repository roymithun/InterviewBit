package com.interviewbit.linkedlist;

public class InsertionSortList {

	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);

		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;

		ListNode head = insertionSortList(n1);
		System.out.println();
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/InsertionSortList.java
	static public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		dummy.next = head;
		ListNode cur = head.next;
		head.next = null;

		while (cur != null) {
			ListNode tmp = dummy;
			while (tmp.next != null && tmp.next.val <= cur.val)
				tmp = tmp.next;
			ListNode next = cur.next;
			cur.next = tmp.next;
			tmp.next = cur;
			cur = next;
		}
		return dummy.next;
	}
}
