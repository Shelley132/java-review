package com.cn.llj.test;

/**
 * @author 刘利娟 liulijuan@gmail.com
 * @version 创建时间4年月日 下午4 类说明：
 */

public class CloneObject implements Cloneable {
	String name;
	CloneObject(String name) {
		this.name = name;
	}
	public Object clone()
	throws CloneNotSupportedException {
		CloneObject result = (CloneObject) super.clone();
		return result;
	}
	protected String getName() {
		return name;
	}
	protected void setName(String name) {
		this.name = name;
	}
	public static void main(String[] args)

	throws CloneNotSupportedException {
		CloneObject co = new CloneObject("Hi!");     //
		CloneObject cloneCo = (CloneObject) co.clone();
		System.out.println(co.getName());					//Hi!
		System.out.println(cloneCo.getName());				//Hi!
		cloneCo.setName("I am Clone! (");					
		System.out.println(co.getName());					//Hi!
		System.out.println(cloneCo.getName());
	}

}
