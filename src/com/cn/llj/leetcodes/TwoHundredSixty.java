package com.cn.llj.leetcodes;


public class TwoHundredSixty {
	public int[] singleNumber(int[] nums) {
		
		// Pass 1 : 
        // Get the XOR of the two numbers we need to find
        int diff = 0;
        for (int num : nums) {
            diff ^= num;
        }
        System.out.println(diff+" "+-diff);
        // Get its last set bit
        diff &= -diff; //原码0101 补码1001
        System.out.println(diff);
        // Pass 2 :
        int[] rets = {0, 0}; // this array stores the two numbers we will return
        //以下将两个single number分到了两个异或表达式中，本例：1,2,2和4,4,5,6,6。分别异或可得1和5.
        for (int num : nums)
        {
            if ((num & diff) == 0) // the bit is not set
            {
                rets[0] ^= num;
            }
            else // the bit is set
            {
                rets[1] ^= num;
            }
        }
        return rets;
		
		
	}
	
	public static void main(String[] args) {
		TwoHundredSixty obj = new TwoHundredSixty();
		//int[] nums = {1,2,2,4,4,5,6,6};
		int[] nums2 = {1,1,3,4,3,4,6,5};
		int[] result = obj.singleNumber(nums2);
		for(int i = 0; i< result.length; i++){
			System.out.println(result[i]);
		}
	}
}
