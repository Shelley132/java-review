package com.cn.llj.leetcodes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WriteNumbers {

	public List<String> getInitialInputs(String inFile) {
		List<String> list = new ArrayList<String>();
		String str = null;
		String[] strs = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), "utf-8"));
			while ((str = br.readLine()) != null) {
				if (str.length() > 0) {
					strs = str.trim().split("\\s+");
					for (int i = 0; i < strs.length; i++) {
						list.add(strs[i]);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

	public void appendToFileEnd(String fileName, String content) {
		try {
			// ��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
			FileWriter writer = new FileWriter(fileName, true);
			writer.write(content);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		String infile = args[0];
		WriteNumbers obj = new WriteNumbers();
		List<String> list = obj.getInitialInputs(infile);
		obj.appendToFileEnd("/usr/local/arm/data/printtokens_2.0/printtokens/inputs/numbers",infile.substring(infile.lastIndexOf("/")+1)+"="+list.size()+"\n");
	}

}
