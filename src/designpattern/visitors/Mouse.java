package designpattern.visitors;
/**
 * 具体元素
 * @author JUANJUAN
 * @version 2017年7月19日上午9:31:35
*/
public class Mouse implements ComputerPart{
	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		// TODO Auto-generated method stub
		computerPartVisitor.visit(this);
	}

}
