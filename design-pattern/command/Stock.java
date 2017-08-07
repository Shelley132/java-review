package command;

/**
 * @author JUANJUAN
 * @version 2017年8月7日下午8:10:38
 */
public class Stock {
	private String name = "ABC";
	private int quantity = 10;

	public void buy(){
	      System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] bought");
	   }

	public void sell(){
	      System.out.println("Stock [ Name: "+name+", Quantity: " + quantity +" ] sold");
	   }
}
