package com.cn.llj.java_base;

public class ShowProperties {

	public static void main(String[] args) {
		
		System.getProperties().list(System.out);//��ʾ�����г����ϵͳ�л�ȡ����������
		
		System.out.println(System.getProperty("user.name"));//��ʾ���г���ϵͳ����������Ϊuser.name������ֵ
		
		System.out.println(System.getProperty("java.library.path"));
	}

}
