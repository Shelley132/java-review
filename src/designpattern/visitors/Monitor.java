package designpattern.visitors;
/**
 * @author JUANJUAN
 * @version 2017年7月19日上午9:33:08
*/
public class Monitor implements ComputerPart{
	@Override
	public void accept(ComputerPartVisitor computerPartVisitor) {
		// TODO Auto-generated method stub
		computerPartVisitor.visit(this);
	}

}
