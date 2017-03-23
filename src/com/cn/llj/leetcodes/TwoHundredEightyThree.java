package com.cn.llj.leetcodes;

public class TwoHundredEightyThree {

	public void moveZeroes(int[] nums) {
        
        for(int i = 0; i < nums.length; i++){
        	if(nums[i]==0){
        		int notZero = findNextNotZero(nums, i);
        		if(notZero < nums.length){
        			nums[i] = nums[notZero];
        			nums[notZero] =0;
        		}
        	}
        }
    }
	
	public int findNextNotZero(int[] nums, int zero){
		for(int i = zero; i<nums.length; i++){
			if(nums[i]!=0)
				return i;
		}
		return nums.length;
	}
	
	public void moveZeroes2(int[] nums) {
	     if  (nums==null) return;
	     int zeroCount = 0;
	     for (int i = 0;i < nums.length; i++) {
	         if (nums[i] == 0) {
	             zeroCount++;
	         } else {
	        	 System.out.println(zeroCount);
	        	 System.out.println("==="+(i-zeroCount));
	             nums[i - zeroCount] = nums[i];
	         }
	     }
	     while (zeroCount > 0) {
	       nums[nums.length - zeroCount--] = 0;
	     }
	     for(int num: nums){
				System.out.println(num);
			}
	 }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {1,0,3,0,4,3};
		TwoHundredEightyThree obj = new TwoHundredEightyThree();
		obj.moveZeroes2(nums);
		
	}

}
