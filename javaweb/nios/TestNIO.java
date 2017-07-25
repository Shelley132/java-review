package nios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author JUANJUAN
 * @version 2017年6月15日下午9:32:45
*/
public class TestNIO {
public static void main(String[] args) {
	RandomAccessFile aFile;
	try {
		aFile = new RandomAccessFile("E:/logs/dir.txt", "rw");
		FileChannel inChannel = aFile.getChannel();  
		  
		ByteBuffer buf = ByteBuffer.allocate(48);  
		  
		int bytesRead = inChannel.read(buf);  
		while (bytesRead != -1) {  
		  
		System.out.println("Read " + bytesRead);  
		buf.flip();  
		  
		while(buf.hasRemaining()){  
		System.out.print((char) buf.get());  
		}  
		  
		buf.clear();  
		bytesRead = inChannel.read(buf);  
		}  
		aFile.close();  
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}  
	
}
}
