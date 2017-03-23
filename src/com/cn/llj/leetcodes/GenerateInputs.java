package com.cn.llj.leetcodes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* *
 * GenerateInputs����ʵ����4���������ֱ���getInitialInputs��getSubset��allSubset��writeFile��
 * 
 * 
 * */

public class GenerateInputs {
	

	public List<String> getInitialInputs(String inFile) {
		List<String> list = new ArrayList<String>();
		String str = null;
		String[] strs = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(inFile), "utf-8"));
			while ((str = br.readLine()) != null) {
				if(str.length()>0){
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

	public Set<String> getSubset(List<String> list, int bits) {
		/* *
		 * ���������������1�ĸ��������󵥴��Ƿ���Ҫ��ӵ������С�
		 * */
		Set<String> set = new HashSet<String>();
		int c = 0;
		while (bits > 0) {
			if ((bits & 1) == 1) {
				// ��ǰλ��1��˵����ǰλ������Ҫ��ӵ������С�
				set.add(list.get(c));
			}
			c++;
			bits >>= 1; // ��λ
		}
		return set;
	}

	public List<Set<String>> allSubset(String infile) {
		/* *
		 * ʹ�ö���������ģ�⼯�ϡ�
		 * ���磺����{1,2,3,4}�����ĸ�Ԫ�أ������ʹ��0~2^4-1��ģ�����Ӽ��ϣ������Ӽ���ob1011={1,3,4}
		 * ��ǰλΪ1ʱ����˵���Ӽ������и�Ԫ��
		 * */
		ArrayList<String> list = (ArrayList<String>) getInitialInputs(infile); // �õ�ԭʼ����
		//appendToFileEnd("E:\\Learning\\ʵ��\\2����\\printtokens_2.0\\printtokens\\inputs\\numbers",infile.substring(infile.lastIndexOf("\\")+1)+"="+list.size()+"\n");
		List<Set<String>> lists = new ArrayList<Set<String>>(); // �����Ӽ���
		for (int i = 1; i < java.lang.Math.pow(2, list.size()) - 1; i++) {
			lists.add(getSubset(list, i));
		}
		return lists;
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
	
	public Set<String> getSet(String filename){
		Set<String> set = new HashSet<String>();
		String str = null;
		String[] strs = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "utf-8"));
			while ((str = br.readLine()) != null) {
				if(str.length()>0){
					strs = str.trim().split("\\s+");
					for (int i = 0; i < strs.length; i++) {
						set.add(strs[i]);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return set;
	}
	

	public static void main(String[] args) {
		String name = args[0];
		GenerateInputs obj = new GenerateInputs();
		List<Set<String>> lists = obj.allSubset("E:\\Learning\\ʵ��\\2����\\printtokens_2.0\\printtokens\\inputs\\" + name);
		for (int i = 0; i < lists.size(); i++) {
			StringBuffer outStr = new StringBuffer();
			Set<String> set = lists.get(i);
			Iterator<String> iter = set.iterator();
			while (iter.hasNext()) {
				String str = (String) iter.next();
				outStr.append(str + "\t");
			}
			obj.writeFile("E:\\Learning\\ʵ��\\2����\\printtokens_2.0\\printtokens\\newinputs\\" + name + "-" + i,
					outStr.toString());
		}
	}
}
