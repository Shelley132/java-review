package com.cn.llj.Override;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月13日 上午11:14:11
 * 类说明：
 */
public class InterfaceTest implements Interface3{

	@Override
	public void getNum() {
		// TODO Auto-generated method stub
		System.out.println("Interface1");
	}

	@Override
	public void getNum2() {
		// TODO Auto-generated method stub
		System.out.println("Interface2");
	}

	@Override
	public void getNum3() {
		// TODO Auto-generated method stub
		System.out.println("Interface3");
	}
	public static void main(String[] args) {
		InterfaceTest inter =  new InterfaceTest();
		inter.getNum();
		inter.getNum2();
		inter.getNum3();
	}
}
