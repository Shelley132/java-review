package tests;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author JUANJUAN
 * @version 2017年6月12日下午3:20:27
*/
class BinaryTreeNode{
	int val;
	BinaryTreeNode left;
	BinaryTreeNode right;
}
public class PreIn {
	public static BinaryTreeNode ConstructTree(int[] preOrder,int[] inOrder) throws Exception{
		
		if(preOrder.length!=inOrder.length){
			throw new Exception("长度不一样，非法的输入");
		}
		
		BinaryTreeNode root=null;
		for(int i=0;i<inOrder.length;i++){
			if(inOrder[i]==preOrder[0]){  //在中序列表中找到根节点的位置
				root = new BinaryTreeNode();
				root.val=inOrder[i];
				System.out.println(root.val+" "+ root.left + " "+ root.right);
				root.left=ConstructTree(Arrays.copyOfRange(preOrder, 1, i+1),Arrays.copyOfRange(inOrder, 0, i));
				root.right=ConstructTree(Arrays.copyOfRange(preOrder, i+1, preOrder.length),Arrays.copyOfRange(inOrder, i+1, inOrder.length));
				
			}
		}
		return root;
		
	}

	public static void levelBinaryTree(BinaryTreeNode root){
		if(root==null){
			return;
		}
		Queue<BinaryTreeNode> queue=new LinkedList<BinaryTreeNode>();
		queue.add(root);
		System.out.println("size:"+queue.size());
		while(!queue.isEmpty()){
				BinaryTreeNode temp=queue.poll();
				
				System.out.print(temp.val+"-> ");
				
				//System.out.println(queue);
				if(temp.left!=null){
					queue.offer(temp.left);
				}
				if(temp.right!=null){
					queue.offer(temp.right);
				}
			
			
		}
		
	}
	public static void main(String[] args) throws Exception {
		int[] preSort={1,2,4,7,3,5,6,8};
		int[] inSort={4,7,2,1,5,3,8,6};

		BinaryTreeNode root=ConstructTree(preSort,inSort);
		System.out.println();
		levelBinaryTree(root);
		System.out.println();
		depth(root);
	   // System.out.println("-----"+root.val);
	}

	public static void depth(BinaryTreeNode root){
		if(root == null){
			return;
		}
		System.out.print(root.val+" ");
		depth(root.left);
		depth(root.right);
	}
}
