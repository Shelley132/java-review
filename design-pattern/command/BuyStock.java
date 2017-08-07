package command;

/**
 * @author JUANJUAN
 * @version 2017年8月7日下午8:12:22
 */
public class BuyStock implements Order {
	private Stock abcStock;

	public BuyStock(Stock abcStock) {
		this.abcStock = abcStock;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		abcStock.buy();
	}
}
