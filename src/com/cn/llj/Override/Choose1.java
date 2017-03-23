package com.cn.llj.Override;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月17日 上午10:15:07
 * 类说明：
 */
public class Choose1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = new Integer(34);
		Long l = new Long(34);
		Double d = new Double(34.0);
		Object obj = new Object();
		System.out.println();
		int[] hh = new int[6];
		int dd = hh.length;
		
		System.out.println(i.equals(l));
		System.out.println(i.equals(d));
		System.out.println(d.equals(i));
		System.out.println(l.equals(34L));
	}

}
