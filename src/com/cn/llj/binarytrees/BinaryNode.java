package com.cn.llj.binarytrees;



/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年6月11日 下午8:12:41 类说明：
 */
public class BinaryNode<T> {
	// 节点元素
	T key;
	//
	BinaryNode<T> parent;
	// 左节点
	BinaryNode<T> left;
	// 右节点
	BinaryNode<T> right;

	public BinaryNode(T key,BinaryNode<T> parent, BinaryNode<T> left,
			BinaryNode<T> right) {
		this.key = key;
		this.parent = parent;
		this.left = left;
		this.right = right;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
