package strategy;
/**
 * @author JUANJUAN
 * @version 2017年8月9日上午9:50:02
*/
public class StrategyPatternDemo {
	   public static void main(String[] args) {
	      Context context = new Context(new OperationAdd());		
	      System.out.println("10 + 5 = " + context.executeStrategy(10, 5));

	      context = new Context(new OperationSubstract());		
	      System.out.println("10 - 5 = " + context.executeStrategy(10, 5));

	      context = new Context(new OperationMultiply());		
	      System.out.println("10 * 5 = " + context.executeStrategy(10, 5));
	   }
	}
