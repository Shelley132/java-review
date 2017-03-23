package com.cn.llj.test;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月13日 下午2:47:18
 * 类说明：
 */
public class GetSubstring {

	public void getSubstring(String s){
		for(int i = 0; i < s.length(); i++){
			for(int j = i+1; j < s.length(); j++)
				System.out.println(s.substring(i,j));
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GetSubstring().getSubstring("abcdefg");
	}

}
