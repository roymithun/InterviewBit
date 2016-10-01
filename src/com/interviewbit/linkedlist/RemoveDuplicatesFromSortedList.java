package com.interviewbit.linkedlist;

public class RemoveDuplicatesFromSortedList {

	public static void main(String[] args) {
		ListNode l7 = new ListNode(10);
		ListNode l6 = new ListNode(8);
		ListNode l5 = new ListNode(6);
		ListNode l4 = new ListNode(6);
		ListNode l3 = new ListNode(6);
		ListNode l2 = new ListNode(5);
		ListNode l1 = new ListNode(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		
		deleteDuplicates(l1);
	}

	static public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode pre = head, cur = head.next;
		while (cur != null) {
			if(pre.val == cur.val) {
                pre.next = cur.next;
            } else {
                pre = pre.next;
            }
            cur = cur.next;
		}
		pre.next = null;
		return head;
	}
}
