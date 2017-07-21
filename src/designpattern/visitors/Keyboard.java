package designpattern.visitors;
/**
 * @author JUANJUAN
 * @version 2017年7月19日上午9:32:37
*/
public class Keyboard implements ComputerPart{
	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		// TODO Auto-generated method stub
		computerPartVisitor.visit(this);
	}

}
