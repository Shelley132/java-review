package templatemethod;

/**
 * @author JUANJUAN
 * @version 2017年8月9日下午2:22:39
 */
public class TemplateMethodPatternDemo {
	public static void main(String[] args) {
		Game game = new Cricket();
		game.play();
		System.out.println();
		game = new Football();
		game.play();
	}
}
