package com.cn.llj.leetcodes;

public class OneHundredSixtySeven {

	public int[] twoSum(int[] numbers, int target) {
		
		for(int i =0, j = numbers.length-1; i< j;){
			if(numbers[i]+numbers[j] == target){
				return new int[]{i+1,j+1};
			}
			else if(numbers[i]+numbers[j] > target){
				j--;
			}else{
				i++;
			}
		}
		return null;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
