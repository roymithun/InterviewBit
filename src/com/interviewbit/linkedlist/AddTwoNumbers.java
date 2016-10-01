package com.interviewbit.linkedlist;

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode l3 = new ListNode(3);
		ListNode l2 = new ListNode(4);
		ListNode l1 = new ListNode(2);

		l1.next = l2;
		l2.next = l3;

		ListNode r3 = new ListNode(4);
		ListNode r2 = new ListNode(6);
		ListNode r1 = new ListNode(5);

		r1.next = r2;
		r2.next = r3;
		
		ListNode l = addTwoNumbers(l1, r1);
		System.out.println();
	}

	static public ListNode addTwoNumbers(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int carry = 0;
		while (a != null || b != null || carry != 0) {
			int sum = carry;
			if (a != null) {
				sum += a.val;
				a = a.next;
			}
			if (b != null) {
				sum += b.val;
				b = b.next;
			}
			carry = sum / 10;
			sum = sum % 10;
			ListNode node = new ListNode(sum);
			cur.next = node;
			cur = cur.next;
		}
		return dummy.next;
	}
}
