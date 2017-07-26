package adapter;
/**
 * @author JUANJUAN
 * @version 2017年7月26日下午2:55:23
*/
public class AudioPlayer implements MediaPlayer{
	MediaAdapter mediaAdapter;

	@Override
	public void play(String audioType, String fileName) {
		// TODO Auto-generated method stub
		//播放mp3音乐文件的内置支持
		if(audioType.equalsIgnoreCase("mp3")){
			System.out.println("Playing mp3 file. Name:"+ fileName);
			//mediaAdapter提供了播放其他文件格式的支持
		}else if(audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")){
			mediaAdapter = new MediaAdapter(audioType);
			mediaAdapter.play(audioType, fileName);
		}else{
			System.out.println("Invalid media. "+ audioType + "format not supported.");
		}
	}
}
