package com.cn.llj.threads;
/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��16�� ����1:21:33
 * ��˵����
 */
public class SimpleCopyShop {

	public static void main(String[] args) {
		Copier canon = new Copier("����");
		Copier sharp = new Copier("����");
		
		Employee simth = new Employee("Simth",2,canon);
		Employee john = new Employee("John",3,sharp);
	
		simth.start();
		john.start();
	
	}
}
