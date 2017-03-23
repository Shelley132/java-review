package com.cn.llj.ios;
import java.io.*;
/**
 *1、 本程序的目的 ：编写一个把输入流中所有应为字母编程大写字母，然后将解惑写入到一个输出流对象的函数，用这个函数来讲一个字符串中的所有的字符转换成大写
 *2、 System.in 连接到键盘，是InputStream类型的实例对象 System.out 连接到显示器，是PrintStream类的实例对象
 *3、不管各种底层物理设备用什么方式实现数据的终止点，InputStream的read方法总是返回-1来表示输入流的结束
 *4、 在windows下，按下crrl+z组合键可以产生键盘输入流的结束标记，在linux下，则是按下ctrl+d组合键产生输入流的结束标记
 *5、建议 编程从键盘上连续读取一大段数据时，应尽量将读取的过程放在函数中完成，使用-1来作为键盘输入的结束点，在该函数中编写的程序代码不应直接使用System.in读取数据，而是用一个InputStream类型的形式参数来读取数据，然后将System.in作为实参传递给InputStream类型的形式参数来调用该函数
     *6、屏幕的共享也可以运用ByteArrayInputStream和ByteArrayOutputStream流实现
 */
public class ByteArrayTest {
	/**
	 * 使用平台的默认字符集将此 String 编码为 byte 序列，并将结果存储到一个新的 byte 数组中。
	 * 当此字符串不能使用默认的字符集编码时，此方法的行为没有指定。
	 * 如果需要对编码过程进行更多控制，则应该使用 CharsetEncoder 类。 
	 * ByteArrayInputStream 包含一个内部缓冲区，该缓冲区包含从流中读取的字节。
	 * 内部计数器跟踪 read 方法要提供的下一个字节。 
	 * 关闭 ByteArrayInputStream 无效。
	 * 此类中的方法在关闭此流后仍可被调用，而不会产生任何 IOException。 
	 * */
	public static void main(String[] args) {
		String stp = "abcdefghigh";
		
		byte buf [] = stp.getBytes();
		
		ByteArrayInputStream input = new ByteArrayInputStream(buf);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		transForm(input,output);
		byte resault [] = output.toByteArray();
		System.out.println(new String(resault));//将字节数组中的所有元素拿出来转换成字符串		
		transForm(System.in,System.out);//将从键盘输入的小写字母转换成大写的字母
		
	}
	
	/**
	 * @param in InputStream
	 * 			输入流
	 * @param out OutputStream
	 * 			输出流
	 */
	public static void transForm(InputStream in,OutputStream out){
		int info = 0;
		try {
			while((info = in.read()) != -1){
				//读取信息
				int uppInfo = Character.toUpperCase((char)info);
				//将 读出的字节信息 转化成大写
				out.write(uppInfo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}

