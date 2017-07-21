package threads;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author LLJ
 * @version 2017年4月4日上午10:53:19
*/
class P172WriteData{
	public void writeMethod(PipedOutputStream out){
		try{
			System.out.println("write:");
			for(int i = 0; i < 300; i++){
				String outData = ""+ (i+1);
				out.write(outData.getBytes());
				System.out.print(outData);
			}
			System.out.println();
			out.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
class P172ReadData{
	public void readMethod(PipedInputStream in){
		try{
			System.out.println("read:");
			byte[] byteArray = new byte[20];
			int readLength = in.read(byteArray);
			while(readLength!=-1){
				String newData = new String(byteArray, 0, readLength);
				System.out.print(newData);
				readLength = in.read(byteArray);
			}
			System.out.println();
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
class P172ReadThread extends Thread{
	private P172ReadData read;
	private PipedInputStream input;
	public P172ReadThread(P172ReadData read, PipedInputStream input){
		this.read = read;
		this.input = input;
	}
	@Override
	public void run(){
		read.readMethod(input);
	}
}
class P172WriteThread extends Thread{
	private P172WriteData write;
	private PipedOutputStream out;
	public P172WriteThread(P172WriteData write, PipedOutputStream out){
		super();
		this.write = write;
		this.out = out;
	}
	@Override
	public void run(){
		write.writeMethod(out);
	}
}
public class P172 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			P172WriteData write = new P172WriteData();
			P172ReadData read = new P172ReadData();
			PipedInputStream input = new PipedInputStream();
			PipedOutputStream out = new PipedOutputStream();
			out.connect(input);
			
			P172ReadThread  rThread = new P172ReadThread(read, input);
			rThread.start();
			
			Thread.sleep(5000);
			
			P172WriteThread wThread = new P172WriteThread(write, out);
			wThread.start();
		}catch(IOException e){
			e.printStackTrace();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
