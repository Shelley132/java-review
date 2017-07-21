package leetcodes;

public class L226 {

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
