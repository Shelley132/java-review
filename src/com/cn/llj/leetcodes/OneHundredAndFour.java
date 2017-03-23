package com.cn.llj.leetcodes;

public class OneHundredAndFour {

	public class Solution {
		//递归方式解决这个问题很合理。求一棵树的最大深度也就是相当于求其左右子树的最大深度+1
		public int maxDepth(TreeNode root) {
			return root==null?0:Math.max(maxDepth(root.left), maxDepth(root.right))+1;
		}
	}

	public static void main(String[] args) {

	}
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}
