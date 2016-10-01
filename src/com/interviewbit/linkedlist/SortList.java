package com.interviewbit.linkedlist;

public class SortList {

	public static void main(String[] args) {
		ListNode l8 = new ListNode(2);
		ListNode l7 = new ListNode(7);
		ListNode l6 = new ListNode(6);
		ListNode l5 = new ListNode(1);
		ListNode l4 = new ListNode(4);
		ListNode l3 = new ListNode(2);
		ListNode l2 = new ListNode(2);
		ListNode l1 = new ListNode(0);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;

		sortList(l1);
		System.out.println(l1);
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/SortList.java
	static public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		ListNode secondHead = slow.next;
		slow.next = null;

		ListNode l1 = sortList(head);
		ListNode l2 = sortList(secondHead);
		return mergeTwoLists(l1, l2);
	}

	static public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode current = dummyHead;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				current.next = l1;
				l1 = l1.next;
			} else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		if (l1 != null)
			current.next = l1;
		if (l2 != null)
			current.next = l2;
		return dummyHead.next;
	}
}
