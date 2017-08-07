package command;

/**
 * @author JUANJUAN
 * @version 2017年8月7日下午8:16:50
 * 
 *          我们首先创建作为命令的接口 Order，然后创建作为请求的 Stock 类。实体命令类 BuyStock 和 SellStock，实现了
 *          Order 接口，将执行实际的命令处理。创建作为调用对象的类 Broker，它接受订单并能下订单。 Broker
 *          对象使用命令模式，基于命令的类型确定哪个对象执行哪个命令。CommandPatternDemo，我们的演示类使用 Broker
 *          类来演示命令模式。
 */
public class CommandPatternDemo {
	public static void main(String[] args) {
		Stock abcStock = new Stock();

		BuyStock buyStockOrder = new BuyStock(abcStock);
		SellStock sellStockOrder = new SellStock(abcStock);

		Broker broker = new Broker();
		broker.takeOrder(buyStockOrder);
		broker.takeOrder(sellStockOrder);

		broker.placeOrders();
	}
}