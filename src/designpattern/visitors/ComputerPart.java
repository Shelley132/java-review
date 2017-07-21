package designpattern.visitors;
/**
 * 抽象元素
 * @author JUANJUAN
 * @version 2017年7月19日上午9:29:01
*/
public interface ComputerPart {
	public void accept(ComputerPartVisitor computerPartVisitor);
}
