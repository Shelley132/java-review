package visitor;
/**
 * 抽象访问者
 * @author JUANJUAN
 * @version 2017年7月19日上午9:30:10
*/
public interface ComputerPartVisitor {
	public void visit(Computer computer);
	public void visit(Mouse mouse);
	public void visit(Keyboard keyboard);
	public void visit(Monitor monitor);
}
