package com.interviewbit.linkedlist;

public class RotateList {

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

		ListNode head = rotateRight(l1, 3);
		System.out.println();
	}

	// https://github.com/leetcoders/LeetCode-Java/blob/master/RotateList.java
	static public ListNode rotateRight(ListNode head, int k) {
		if (head == null) {
			return head;
		}

		ListNode tail = head;
		ListNode cur = head;

		int n = 1;// length of the list
		while (tail.next != null) {
			n++;
			tail = tail.next;
		}

		// reset k to rotate position
		k = k % n;
		if (k == 0)
			return head;
		for (int i = 0; i < n - k - 1; ++i)
			cur = cur.next;

		ListNode newHead = cur.next;
		tail.next = head;
		cur.next = null;
		return newHead;
	}
}
