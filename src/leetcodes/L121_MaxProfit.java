package leetcodes;

public class L121_MaxProfit {

	public int maxProfit(int[] prices) {
		
		if(prices!=null&&prices.length>0){
			int min = prices[0];
			int max = 0;
			for(int i = 1; i< prices.length; i++){
				if(min>prices[i])
					min = prices[i];
				else if(max<prices[i]-min){
					max = prices[i]-min;
				}
			}
			return max;	
		}
        return 0;
    }
	public static void main(String[] args) {
		int[] nums = {7, 1, 5, 3, 6, 4};
		L121_MaxProfit obj = new L121_MaxProfit();
		System.out.println(obj.maxProfit(nums));
	}
}
