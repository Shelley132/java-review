package wy.com;

import java.util.Scanner;

public class StringTest {

	
	public String getNewCoding(String str){
		if(str == null){
			return null;
		}
		StringBuffer newStr = new StringBuffer();
		int i = 0;
		int nums = 1;
		while(i < str.length()-1){
			if(str.charAt(i+1) == str.charAt(i)){
				nums++;
			}else {
				newStr.append(nums +""+ str.charAt(i));
				nums = 1;
			}
			i++;
		}
		if(newStr.toString().length() == 0){
			newStr.append(str.length()+""+ str.charAt(0));
		}else{
			newStr.append(nums+""+str.charAt(str.length()-1));
		}
		return newStr.toString();
	}
	
	public static void main(String[] args) {
		StringTest test = new StringTest();
		System.out.println(test.getNewCoding("AAAAAAB"));

	}

}
