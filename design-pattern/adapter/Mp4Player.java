package adapter;
/**
 * @author JUANJUAN
 * @version 2017年7月26日下午2:48:27
*/
public class Mp4Player implements AdvancedMediaPlayer{

	@Override
	public void playVlc(String fileName) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void playMp4(String fileName) {
		// TODO Auto-generated method stub
		System.out.println("Playing mp4 file. Names: "+ fileName);
	}

}
