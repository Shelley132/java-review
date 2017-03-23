package com.cn.llj.leetcodes;

public class ThreeHundredSeventyOne {

	public static int i = 0;
	
	public int getSum(int a, int b) {
		int x = a & b;
		if (x == 0) {// 没有进位数,合并
			return a | b;
		} else {
			i++;
			x <<= 1;// 进位
			int y = a ^ b;// 非进位合并
			return getSum(x, y);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeHundredSeventyOne obj = new ThreeHundredSeventyOne();
		System.out.println(obj.getSum(2, 3));
		System.out.println(i);
	}

}
