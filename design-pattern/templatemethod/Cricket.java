package templatemethod;
/**
 * @author JUANJUAN
 * @version 2017年8月9日下午2:11:59
*/
public class Cricket extends Game{
	@Override
	void initialize() {
		// TODO Auto-generated method stub
		System.out.println("Cricket Game Initialized! Start playing.");
	}
	@Override
	void startPlay() {
		// TODO Auto-generated method stub
		System.out.println("Criket game started! Enjoy the game.");
	}
	@Override
	void endPlay() {
		// TODO Auto-generated method stub
		System.out.println("Criket game finished.");
	}
}
