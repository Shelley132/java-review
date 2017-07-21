package leetcodes;

public class L238 {
	public int[] productExceptSelf(int[] nums) {
	    int n = nums.length;
	    int[] res = new int[n];
	    res[0] = 1;
	   
	    //从左向右遍历，得到每个数的左面的几个数的乘积
	    for (int i = 1; i < n; i++) {
	        res[i] = res[i - 1] * nums[i - 1];
	    }
	    //从右向左遍历，分别得到每个数的右边的乘积，跟上一步中得到的左面的乘积相乘，得到结果。
	    int right = 1;
	    for (int i = n - 1; i >= 0; i--) {
	        res[i] *= right;
	        right *= nums[i];
	    }
	    return res;
	}
	
	public int[] productExceptSelf2(int[] nums) {
        int[] res = new int[nums.length];

        res[0] = 1;
        for(int i=1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        for(int j = nums.length - 1; j > 0; j--) {
            res[j] *= res[0];
            res[0] *= nums[j];
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		L238 obj = new L238();
		int[] nums = {3,2,3,4,5,6};
		int[] res = obj.productExceptSelf2(nums);
		for(int i = 0; i < res.length; i++){
			System.out.println(res[i]);
		}
	}

}
