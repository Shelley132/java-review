package com.cn.llj.test;

public final class Son extends Dad{
 public int i;
 public void set(){
	 super.set();
	System.out.println(super.i);
	 System.out.println("子类");
 }
 public static void main(String[] args) {
	Son son = new Son();
	son.set();
}
}
