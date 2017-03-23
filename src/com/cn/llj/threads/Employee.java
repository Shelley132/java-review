package com.cn.llj.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��16�� ����1:16:31
 * ��˵����
 */
public class Employee extends Thread{
	private int workTimes;//��Ա��һ��Ĺ����ݶ�
	private Copier copier;//��ӡ��
	
	public Employee(String name, int workTimes, Copier copier){
		super(name);
		this.workTimes = workTimes;
		this.copier = copier;
	}
	public void run(){
		System.out.println(new SimpleDateFormat("yyyyMMdd-HH:mm:ss").format(new Date())+"\t"+this.getName() + ": ��ʼ������");
		for(int i = 0; i < workTimes; i++){
			int pageAmount = (int)(5 * Math.random()+1);
			System.out.println(this.getName()+"\t"+"����ҳ��Ϊ��"+pageAmount);
			copier.copyPages(pageAmount);
		}
		System.out.println(new SimpleDateFormat("yyyyMMdd-HH:mm:ss").format(new Date())+"\t"+this.getName() + ":����˹������°ࡣ");
	}
}
