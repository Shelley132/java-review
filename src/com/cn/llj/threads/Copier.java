package com.cn.llj.threads;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author ������ liulijuan132@gmail.com
 * @version ����ʱ��:2014��1��16�� ����11:46:05
 * ��˵����
 * ��ӡ����
 */
public class Copier {
	private String name;//��ӡ������
	/**
	 * @param name String 
	 * 			��ӡ������
	 */
	public Copier(String name){//���췽��������Ϊ��ӡ������
		this.name = name;
	}
	/**
	 * @return String 
	 * 			���ظ�ӡ������
	 */
	public String getName(){//�õ���ӡ��������
		return name;
	}
	/**
	 * ʵ�ָ�ӡ
	 * @param pages Integer
	 * 			Ҫ��ӡ��ҳ��
	 */
	public void copyPages(int pages){//��ӡ
		Thread employee = Thread.currentThread();//�õ���ǰ��Ա���߳�
		System.out.println(new SimpleDateFormat("yyyyMMdd-HH:mm:ss").format(new Date())+"\t"+
				employee.getName() + "\t����ʹ�ø�ӡ��\t" + name);
		long time = pages * 1000;
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("�������г���������Ϣ��"+e.getMessage());
		}
		System.out.println(new SimpleDateFormat("yyyyMMdd-HH:mm:ss").format(new Date())+"\t"+employee.getName() + "\t�����˴�ӡ��\t" + name);
	}
}
