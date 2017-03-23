package com.cn.llj.binarytrees;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年6月11日 下午8:35:23
 * 类说明：
 */
public class BSTreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTree<Integer> test = new BSTree<Integer>();
		test.insert(7);
		test.insert(4);
		test.insert(5);
		test.insert(6);
		test.insert(12);
		test.insert(10);
		test.insert(8);
		test.insert(9);
		test.insert(11);
		
		test.print();
		System.out.println("前序：");
		test.preOrder();
		test.print();
		test.remove(10);
		test.inOrder();
		test.print();
	}

}
