package com.cn.llj.leetcodes;
/**
 * @author LLJ
 * @version 2017年3月28日下午10:13:17
*/
public class KMP {
	public void matchByKMP( String string,String pattern){
		int[] values = getMatchValue(pattern);
		int i = 0, j =0;
		while(i < string.length() && j <  pattern.length()){
			if(pattern.charAt(j)==string.charAt(i)){
				i++;
				j++;
			}else{
				j = string.length()-1 - values[j];
			}
			System.out.println(j);
		}
		if (j == string.length()){
			System.out.println("Found ");
		}
			
		
	}
	public int[] getMatchValue(String pattern){
		int[] values = new int[pattern.length()];
		for(int i = 0; i < pattern.length(); i++){
			
			String s;
			if(i== 0)
				values[i] = 0;
			else{
				s = pattern.substring(0,i+1);
				for(int j = 1; j < i; j++){
					if(s.length()>1 && s.substring(0, j).equals(s.substring(s.length()-j))){
						values[i] = j;
					}
				}
			}		
		}
		
		return values;
	}
	
	
	
	     
	  
	    /** 
	     * 获得字符串的next函数值 
	     *  
	     * @param t 
	     *            字符串 
	     * @return next函数值 
	     */  
	    public static int[] next(char[] t) {  
	        int[] next = new int[t.length];  
	        next[0] = -1;  
	        int i = 0;  
	        int j = -1;  
	        while (i < t.length - 1) {  
	            if (j == -1 || t[i] == t[j]) {  
	                i++;  
	                j++;  
	                if (t[i] != t[j]) {  
	                    next[i] = j;  
	                } else {  
	                    next[i] = next[j];  
	                }  
	            } else {  
	                j = next[j];  
	            }  
	        }  
	        return next;  
	    }  
	  
	    /** 
	     * KMP匹配字符串 
	     *  
	     * @param s 
	     *            主串 
	     * @param t 
	     *            模式串 
	     * @return 若匹配成功，返回下标，否则返回-1 
	     */  
	    public static int KMP_Index(char[] s, char[] t) {  
	        int[] next = next(t);  
	        int i = 0;  
	        int j = 0;  
	        while (i <= s.length - 1 && j <= t.length - 1) {  
	            if (j == -1 || s[i] == t[j]) {  
	                i++;  
	                j++;  
	            } else {  
	                j = next[j];  
	            }  
	        }  
	        if (j < t.length) {  
	            return -1;  
	        } else  
	            return i - t.length; // 返回模式串在主串中的头下标  
	    }  

	public static void main(String[] args) {
		
	        String s = "abbabbbbcab"; // 主串  
	        String t = "bbcab"; // 模式串  
	        char[] ss = s.toCharArray();  
	        char[] tt = t.toCharArray();  
	        System.out.println(KMP_Index(ss, tt)); // KMP匹配字符串  
	  
	}
}
