package visitor;
/**
 * @author JUANJUAN
 * @version 2017年7月19日上午9:38:58
*/
public class VisitorPatternDemo {
	   public static void main(String[] args) {

	      ComputerPart computer = new Computer();
	      computer.accept(new ComputerPartDisplayVisitor());
	   }
	}
