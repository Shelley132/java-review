package com.cn.llj.leetcodes;
import java.util.Random;

public class ThreeHundredEightyTwo {

	ListNode head = null;
	Random randomGenerator = null;

	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be
	 *            not null, so it contains at least one node.
	 */
	public ThreeHundredEightyTwo(ListNode head) {
		this.head = head;
		this.randomGenerator = new Random();
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode result = null;
		ListNode current = head;

		for (int n = 1; current != null; n++) {
			//nextInt返回一个伪随机数，它是取自此随机数生成器序列的、在 0（包括）和指定值（不包括）之间均匀分布的 int 值。
			//nextInt的常规协定是，伪随机地生成并返回指定范围中的一个 int 值。所有可能的 n 个 int 值的生成概率（大致）相同。
			//等于0就相当于是当前节点，因为产生的随机数范围是0 ~ n-1
			if (randomGenerator.nextInt(n) == 0) {
				result = current;
			}
			current = current.next;
		}

		return result.val;
	}

	/**
	 * Your Solution object will be instantiated and called as such: Solution
	 * obj = new Solution(head); int param_1 = obj.getRandom();
	 */
	public static void main(String[] args) {
		Random ran = new Random();
		for(int i = 0; i < 10; i++)
			System.out.println(ran.nextInt(5));
	}
}
