package com.cn.llj.leetcodes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CompareOutputs {

	public Set<String> getOutputs(String filename){
		String str = null;
		Set<String> set = new HashSet<String>();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf-8"));
			while ((str = br.readLine()) != null) {
				if(str.length()>0){
					set.add(str.trim());
				}
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return set;
	}
	
	public void printSet(Set<String> set){
		Iterator<String> iter = set.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
	}

	public void writeFile(String outFile, String outStr) {
		File file = new File(outFile);
		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "utf-8"));
			out.write(outStr);
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void appendToFileEnd(String fileName, String content) {
        try {
            //��һ��д�ļ��������캯���еĵڶ�������true��ʾ��׷����ʽд�ļ�
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		CompareOutputs obj = new CompareOutputs();
		String str1 = args[0];
		String str2 = args[1];
		Set<String> set = obj.getOutputs(str1);
		//"E:\\Learning\\ʵ��\\2����\\printtokens_2.0\\printtokens\\gcovs\\" + "otc2-1"
		Set<String> set2 = obj.getOutputs(str2);
		String com = null;
		if(set.containsAll(set2)){
			com = str1 + " and "+ str2 + ": true\r\n" ;
		}else{
			com = str1 + " and "+ str2 + ": false\r\n" ;
			obj.appendToFileEnd("E:\\Learning\\ʵ��\\2����\\printtokens_2.0\\printtokens\\diffs\\diff-bug", com);
		}
		obj.appendToFileEnd("E:\\Learning\\ʵ��\\2����\\printtokens_2.0\\printtokens\\diffs\\diff",com);
	}
}
