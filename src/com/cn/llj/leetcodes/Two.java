package com.cn.llj.leetcodes;

public class Two {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;

		ListNode head = new ListNode(0);
		ListNode p = head;

		int tmp = 0;
		while (l1 != null || l2 != null || tmp != 0) {
			//
			if (l1 != null) {
				tmp += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				tmp += l2.val;
				l2 = l2.next;
			}

			p.next = new ListNode(tmp % 10);
			p = p.next;
			tmp = tmp / 10;
		}
		return head.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(2);
		ListNode second = new ListNode(4);
		head.next = second;
		ListNode third = new ListNode(3);
		second.next = third;
		third.next = null;

		ListNode head2 = new ListNode(5);
		ListNode second2 = new ListNode(6);
		head2.next = second2;
		ListNode third2 = new ListNode(4);
		second2.next = third2;
		third2.next = null;

		Two test = new Two();
		ListNode l = test.addTwoNumbers(head2, head2);
		while (l.next != null) {
			System.out.println(l.val);
			l = l.next;
		}
	}

}
