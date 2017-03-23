package com.cn.llj.java_base;

class Test {
	int t;
}
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年1月4日 下午10:17:46 类说明：该类主要验证对象赋值的实质。
 */
public class Assignment {
	public static void main(String[] args) {
		Test t1 = new Test();
		Test t2 = new Test();
		t1.t = 1;
		t2.t = 2;
		System.out.println("Test1:" + t1.t + " Test2:" + t2.t);
		t1 = t2;
		System.out.println("Test1:" + t1.t + " Test2:" + t2.t);
	}
	/* 输出结果：
	 * Test1:1 Test2:2 
	 * 
	 * Test1:2 Test2:2
	 */
}
