package visitor;

/**
 * 具体访问者
 * 
 * @author JUANJUAN
 * @version 2017年7月19日上午9:34:25
 */
public class ComputerPartDisplayVisitor implements ComputerPartVisitor {
	@Override
	public void visit(Computer computer) {
		System.out.println("Displaying Computer.");
	}

	@Override
	public void visit(Mouse mouse) {
		System.out.println("Displaying Mouse.");
	}

	@Override
	public void visit(Keyboard keyboard) {
		System.out.println("Displaying Keyboard.");
	}

	@Override
	public void visit(Monitor monitor) {
		System.out.println("Displaying Monitor.");
	}

}
