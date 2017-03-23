package com.cn.llj.leetcodes;

public class ThreeHundredFortyFour {
	public String reverseString(String s) {
        char[] ss = s.toCharArray();
        for(int i = 0; i < ss.length/2; i++){
        	char c = ss[i];
        	ss[i] = ss[ss.length-1-i];
        	ss[ss.length-1-i] =c;
        }
        return new String(ss);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeHundredFortyFour obj = new ThreeHundredFortyFour();
		System.out.println(obj.reverseString("substring"));
	}

}
