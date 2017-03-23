package com.cn.llj.leetcodes;

public class TwoHundredTwentySix {

	public TreeNode invertTree(TreeNode root) {

		if(root ==null)
			return null;
		
		invertTree(root.left);
		invertTree(root.right);
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		return root;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
