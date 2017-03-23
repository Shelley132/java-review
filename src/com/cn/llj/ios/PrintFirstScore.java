package com.cn.llj.ios;

import java.io.*;
import java.util.*;

/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年3月9日 上午8:35:11
 * 类说明：
 * 从score.txt和info.txt文件中读取数据，输出各学院各专业的第一名的姓名。
 */

class Student{
	private int sno;			//学号
	private String college;		//学院
	private String major;		//专业
	private String name;		//姓名
	private int score;			//分数
	
	public Student(){
		
	}
	
	public Student(int sno,String college,String major,String name,int score){
		this.sno = sno;
		this.college = college;
		this.major = major;
		this.name = name;
		this.score = score;
	}
	public int getSno(){
		return this.sno;
	}
	public void setSno(int sno){
		this.sno = sno;
	}
	public String getCollege(){
		return this.college;
	}
	public void setCollege(String college){
		this.college = college;
	}
	public String getMajor(){
		return this.major;
	}
	public void setMajor(String major){
		this.major = major;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getScore(){
		return this.score;
	}
	public void setScore(int score){
		this.score = score;
	}
	
	public String toString(){
		return this.sno + "," +this.college+ "," +this.major+ "," +this.name+ "," +this.score +"\n" ;
	}
}
public class PrintFirstScore {

	ArrayList<Student> list = new ArrayList<Student>();
	
	public void readInfo(String filename){
		String str;
		BufferedReader br = null;
		try {
			
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				int sno = 0;
				String college = null;
				String major = null;
				String name = null;
				while((str = br.readLine()) != null && str.length() >0){
					System.out.println(str.trim());
					String[] strs = str.trim().split("\t");
					String no = strs[0].replace("&#xFEFF;","");
					sno = Integer.parseInt(no);
					college = strs[1].trim();
					major = strs[2].trim();
					name = strs[3].trim();
					Student student = new Student(sno,college,major,name,0);
					list.add(student);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("未找到该文件！");
		}
	}
	
	public void readScore(String filename){
		String str = null;
		BufferedReader br = null;
		try {
			
			try {
				br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				int sno = 0;
				String kecheng = null;
				int score = 0;
				while((str = br.readLine()) != null && str.length() >0){
					System.out.println(str);
					String[] strs = str.split("\t");
					sno = Integer.parseInt(strs[0].trim());
					score = Integer.parseInt(strs[2].trim());
					System.out.println(sno + "--" + score);
					
					for(int i = 0; i < list.size(); i++){
						Student stu = list.get(i);
						if(stu.getSno()==sno){
							stu.setScore(stu.getScore() + score);
							list.set(i, stu);
						}
					}
				}
				for(int i = 0; i < list.size(); i++){
					Student stu = list.get(i);
					System.out.println(stu.toString());
				}
				output("D:\\first.txt");
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("未找到该文件！");
		}
	}
	
	public void output(String filename){
		try {
			File file = new File(filename);
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
			try {
				for (int i = 0; i < list.size(); i++) {
					Student student = list.get(i);
					out.write(student.getSno() + "\t");
					out.write(student.getName() + "\t");
					out.write(student.getScore());	
					out.newLine();
				}
			} finally {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		PrintFirstScore print = new PrintFirstScore();
		print.readInfo("D:\\info.txt");
		print.readScore("D:\\score.txt");
	}

}
