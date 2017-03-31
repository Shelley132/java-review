package com.cn.llj.hashmaps;

import java.util.HashMap;
import java.util.Map.Entry;

/**
 * @author LLJ
 * @version 2017年3月15日下午8:06:02
*/
public class HashMapTest1 {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		for(int i = 20; i>0; i--){
			map.put("Key"+i, i);
		}
		
		for(Entry<String,Integer> e : map.entrySet()){
			System.out.println(e.getKey()+","+ e.getValue());
		}
	}

}
