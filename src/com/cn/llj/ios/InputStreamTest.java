package com.cn.llj.ios;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class InputStreamTest {
	static String path = "src/com/cn/llj/ios/InputStreamTest.java";
	static String path2 = "E:\\My Data/My essay/10.doc";//这两种方法输出到控制台都是乱码。
	static String path3 = "E:\\My Data/My essay/11.doc";//没有乱码
	static String path4 = "E:\\My Data/My essay/12.doc";//全部乱码
	/*static String path2 = "E:\\My Data/My essay/0.txt";//两个文档都是全中文，验证中文的乱码问题。
	static String path3 = "E:\\My Data/My essay/1.txt";//没有乱码，无论哪种方式都没有乱码。
	static String path4 = "E:\\My Data/My essay/2.txt";//当使用文件使用GBK编码时，没有乱码；如果默认为utf-8，则乱码。
*/
	/**
     * 使用FileInputStream读取该类本身
     * */
    public static void FileInputStreamTest() throws Exception{
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
        //创建字节输入流
        fis = new FileInputStream(path2);
        fos = new FileOutputStream(path3);
        //创建一个长度为1024的字节数组来存取
        byte[] bbuf = new byte[1024];
        int num = 0;
        //用于保存实际读取的字节数
        int hasRead = 0;
        //使用循环来进行重复读取
        while((hasRead = fis.read(bbuf))> 0){
            //取出字节，将字节数组转化为字符串输出
            System.out.println(new String(bbuf, 0 , hasRead));
            fos.write(bbuf, 0 , hasRead);
            num = num + hasRead;
        }
        System.out.println("num ===       "+num);
        }finally{
            //关闭文件输入流
            fis.close();
            fos.close();
        }
    }
    /**
     * 使用FileReader读取该类本身
     * */
    public static void FileReaderTest() throws Exception{    
        FileReader fr = null;
        FileWriter fw = null;
        try{
        //创建字符输入流
        fr = new FileReader(path2);
        fw = new FileWriter(path4);
        //创建一个长度为40的字符数组来存取
        char[] bbuf = new char[40];
        int num = 0;
        //用于保存实际读取的字符数
        int hasRead = 0;
        //使用循环来进行重复读取
        while((hasRead = fr.read(bbuf))> 0){
            //取出字节，将字节数组转化为字符串输出
            System.out.println(new String(bbuf, 0 , hasRead));
            fw.write(bbuf, 0 , hasRead);
            num = num + hasRead;
        }
        System.out.println("num ===------       "+num);
        //两个方法的num分别以字节和字符为单位，所以上一个方法中的num是这个方法的两倍。
        }finally{
        	
            //关闭文件输入流
            fr.close();
            fw.close();
        }
    }
    public static void main(String[] args) throws Exception{
        InputStreamTest.FileInputStreamTest();
        InputStreamTest.FileReaderTest();
    }
}
