package com.cn.llj.leetcodes;

import java.util.ArrayList;
import java.util.List;

public class TestListContains {
	
public static void main(String[] args) {
	String[] inputs = {"今天","星期几","是","嘛"};
	List<String> inputss = new ArrayList<String>();
	for(int i = 0; i< inputs.length; i++){
		inputss.add(inputs[i]);
	}
	String[] inputs2 = {"今天","星期几","嘛"};
	List<String> inputss2 = new ArrayList<String>();
	for(int i = 0; i< inputs2.length; i++){
		inputss.add(inputs2[i]);
	}
	System.out.println(inputss.containsAll(inputss2));
	
}
}
