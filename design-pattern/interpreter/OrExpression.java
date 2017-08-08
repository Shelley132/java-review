package interpreter;
/**
 * @author JUANJUAN
 * @version 2017年8月8日上午10:35:45
*/
public class OrExpression implements Expression{
	
	private Expression expr1;
	private Expression expr2;
	
	public OrExpression(Expression expr1, Expression expr2){
		this.expr1 = expr1;
		this.expr2 = expr2;
	}
	
	@Override
	public boolean interpret(String context) {
		// TODO Auto-generated method stub
		return expr1.interpret(context) || expr2.interpret(context);
	}

}
