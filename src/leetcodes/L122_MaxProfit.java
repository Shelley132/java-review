package leetcodes;

public class L122_MaxProfit {

public int maxProfit(int[] prices) {
	
		    int total = 0;
		    for (int i=0; i< prices.length-1; i++) {
		        if (prices[i+1]>prices[i]) total += prices[i+1]-prices[i];
		    }
		    
		    return total;
    }
	
public int maxProfix2(int[] prices){
	int length = prices.length;
	if (length < 2) {
		return 0;
	}
	int profit = 0;
	int lastBuy = prices[0];
	for (int i = 1; i < length; i++) {
		if (prices[i]>lastBuy) {
			profit = prices[i] - lastBuy + profit;
		}
		lastBuy = prices[i];
	}
	return profit;
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
