package com.cn.llj.test;

import java.util.ArrayList;

/**
 * @author LLJ
 * @version 2017年3月17日下午3:16:53
*/
public class TestList {
	public void set(ArrayList<int[]> list){
		list.set(0, new int[]{222});
	}
public static void main(String[] args) {
	ArrayList<int []> list = new ArrayList<int[]>();
	for(int i = 0; i< 10;i++){
		list.add(new int[]{1,2,3});
	}
	new TestList().set(list);
	for(int[] i : list){
		System.out.println(i[0]);
	}
}
}
