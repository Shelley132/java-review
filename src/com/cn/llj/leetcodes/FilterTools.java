package com.cn.llj.leetcodes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FilterTools {

	public static void filterFiles(String inFile, String outFile) {
		String str = null;
		StringBuffer outStr = new StringBuffer();
		BufferedReader br = null;
		String deleteLine = "\\s*[#]{5}:\\s*\\d*:.*";
		// String retainLine = "\\s*[-]:\\s*[0]:.*";
		Pattern p = Pattern.compile(deleteLine);
		// Pattern p2 = Pattern.compile(retainLine);
		int i = 0;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), "utf-8"));
			while ((str = br.readLine()) != null && str.length() > 0) {
				if (i < 5) {
					i++;
				} else {
					Matcher m = p.matcher(str);
					if (m.matches()) {
						if (str.contains("break") || str.contains("return")) {
							String str2 = str.replaceFirst("\\s*[#]{5}:\\s*\\d*:", "");
							outStr = outStr.append(str2 + "\r\n");
						} else if (str.contains("}")){
							String str2 = str.replaceFirst("\\s*[#]{5}:\\s*\\d*:", "");
							if(str2.trim().equals("}")){
								outStr = outStr.append(str2+"\r\n");
							}else{
								outStr = outStr.append(";\r\n");
							}
						}else
							outStr = outStr.append(";\r\n");
					} else {
						String str2 = str.replaceFirst("\\s*([-]|(\\d*)):\\s*\\d*:", "");
						outStr = outStr.append(str2 + "\r\n");
					}
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		File file = new File(outFile);
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			out.write(outStr.toString());
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		String infile = args[0];
		String outfile = args[1];
		//Scanner scan = new Scanner(System.in);
		//String infile = "E:\\Learning\\ʵ��\\2����\\printtokens_2.0\\printtokens\\gcov\\t1.c.gcov";
		//String outfile = "E:\\Learning\\ʵ��\\2����\\printtokens_2.0\\printtokens\\gcov\\t1.c";
		//String infile = scan.next();
		//String outfile = scan.next();
		FilterTools.filterFiles(infile, outfile);
		// "E:\\Learning\\ʵ��\\2����\\printtokens_2.0\\printtokens\\gcov\\t1.c.gcov",
		// "E:\\Learning\\ʵ��\\2����\\printtokens_2.0\\printtokens\\gcov\\t1.c"
	}

}
