package com.interviewbit.linkedlist;

public class RemoveDuplicatesFromSortedListII {
	public static void main(String[] args) {
		ListNode l7 = new ListNode(10);
		ListNode l6 = new ListNode(8);
		ListNode l5 = new ListNode(6);
		ListNode l4 = new ListNode(6);
		ListNode l3 = new ListNode(5);
		ListNode l2 = new ListNode(1);
		ListNode l1 = new ListNode(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;

		deleteDuplicates(l1);
	}

	// http://www.programcreek.com/2014/06/leetcode-remove-duplicates-from-sorted-list-ii-java/
	static public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode temp = new ListNode(0);
		temp.next = head;

		ListNode cursor = temp;

		while (cursor.next != null && cursor.next.next != null) {
			if (cursor.next.val == cursor.next.next.val) {
				int duplicate = cursor.next.val;
				while (cursor.next != null && cursor.next.val == duplicate) {
					cursor.next = cursor.next.next;
				}
			} else {
				cursor = cursor.next;
			}
		}

		return temp.next;
	}
}
