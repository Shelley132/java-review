package com.cn.llj.test;

import java.util.Scanner;

/**
 * @author LLJ
 * @version 2017年3月25日下午2:41:17
*/
public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		int[] a = new int[number];
		for(int i = 0; i< number; i++){
			a[i] = scan.nextInt();
		}
		
		int[] result = new int[a.length];
		int index = 0,i,j;
		for(i=0; i < a.length; i++){
			j=0;
			while(j < index){
				if(a[i]==result[j]){
					for(int k = j; k< index-1; k++){
						result[k]= result[k+1];
					}
					result[index-1] = a[i];
					break;
				}
				j++;
			}
			if(j==index){
				result[j] = a[i];
				index++;
			}
		}
		for(i = 0; i< index;i++)
			System.out.println(result[i]);
	}

}
