package threads;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author LLJ
 * @version 2017年4月12日上午10:41:55
*/

public class P242 {
	//private static Timer timer = new Timer(true);
	static public class P242Task extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("运行了！时间为："+ new Date());
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			P242Task task = new P242Task();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			Date date = sdf.parse("2017-04-12 11:05:00");
			Timer timer = new Timer();
			System.out.println("字符串时间："+ date.toLocaleString()+ "当前时间："+ new Date().toLocaleString());
			timer.schedule(task, date, 4000);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
