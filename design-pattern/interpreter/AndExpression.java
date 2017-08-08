package interpreter;
/**
 * @author JUANJUAN
 * @version 2017年8月8日上午10:32:04
*/
public class AndExpression implements Expression{

	private Expression expr1 = null;
	private Expression expr2 = null;
	
	public AndExpression(Expression expr1, Expression expr2){
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public boolean interpret(String context) {
		// TODO Auto-generated method stub
		return expr1.interpret(context) && expr2.interpret(context);
	}
	
}
