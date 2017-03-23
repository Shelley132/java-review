package com.cn.llj.test;
/**
 * @author LLJ
 * @version 2017年3月10日下午9:07:54
*/
public class OuterClass {

	private int o = 99;
	String name = "Jackson";
	public class InnerClass{
		String in = "Little Jackson";
		public String getIn(){
			return in;
		}
	}
	public InnerClass getInnerClass(){
		return new InnerClass();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OuterClass outer = new OuterClass();
		System.out.println(outer.getInnerClass().getIn());
		
	}

}
