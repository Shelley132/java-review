package command;

/**
 * @author JUANJUAN
 * @version 2017年8月7日下午8:13:24
 */
public class SellStock implements Order {
	private Stock abcStock;

	public SellStock(Stock abcStock) {
		this.abcStock = abcStock;
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		abcStock.sell();
	}
}
