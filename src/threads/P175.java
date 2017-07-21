package threads;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * @author LLJ
 * @version 5017年4月4日上午11:44:56
*/
class P175WriteData{
	public void writeMethod(PipedWriter out){
		try{
			System.out.println("write:");
			for(int i = 0; i < 300; i++){
				String outData = ""+ (i+1);
				out.write(outData);
				System.out.print(outData);
			}
			System.out.println();
			out.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
class P175ReadData{
	public void readMethod(PipedReader in){
		try{
			System.out.println("read:");
			char[] charArray = new char[20];
			int readLength = in.read(charArray);
			while(readLength!=-1){
				String newData = new String(charArray, 0, readLength);
				System.out.print(newData);
				readLength = in.read(charArray);
			}
			System.out.println();
			in.close();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
class P175ReadThread extends Thread{
	private P175ReadData read;
	private PipedReader input;
	public P175ReadThread(P175ReadData read, PipedReader input){
		this.read = read;
		this.input = input;
	}
	@Override
	public void run(){
		read.readMethod(input);
	}
}
class P175WriteThread extends Thread{
	private P175WriteData write;
	private PipedWriter out;
	public P175WriteThread(P175WriteData write, PipedWriter out){
		super();
		this.write = write;
		this.out = out;
	}
	@Override
	public void run(){
		write.writeMethod(out);
	}
}
public class P175 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		try{
			P175WriteData write = new P175WriteData();
			P175ReadData read = new P175ReadData();
			PipedReader input = new PipedReader();
			PipedWriter out = new PipedWriter();
			out.connect(input);
			
			P175ReadThread  rThread = new P175ReadThread(read, input);
			rThread.start();
			
			Thread.sleep(2000);
			
			P175WriteThread wThread = new P175WriteThread(write, out);
			wThread.start();
		}catch(IOException e){
			e.printStackTrace();
		}catch(InterruptedException e){
			e.printStackTrace();
		}
	}

}
