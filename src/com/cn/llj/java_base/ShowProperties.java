package com.cn.llj.java_base;

public class ShowProperties {

	public static void main(String[] args) {
		
		System.getProperties().list(System.out);//显示从运行程序的系统中获取的所有属性
		
		System.out.println(System.getProperty("user.name"));//显示运行程序系统中属性名称为user.name的属性值
		
		System.out.println(System.getProperty("java.library.path"));
	}

}
