package com.cn.llj.java_base;

public class BaseTypeTest {
	boolean b ;
	byte bt;
	short sh;
	int i;
	long l;
	float f;
	double d;
	char c;
	public static void main(String[] args) {
		BaseTypeTest btt = new BaseTypeTest();
		System.out.println(btt.b+","+btt.bt+","+btt.sh+","+btt.i+","+btt.l+","+btt.f+","+btt.d+","+btt.c);
		//false,0,0,0,0,0.0,0.0,
		//以上为默认的值，只有当变量作为类的内部成员时，Java才给其默认值。
	}

}
