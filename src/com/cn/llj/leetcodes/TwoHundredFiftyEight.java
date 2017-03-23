package com.cn.llj.leetcodes;
import java.util.Date;

public class TwoHundredFiftyEight {

	public int addDigits(int num) {
		
		while(num >9){
			num = add(num);
		}
        return num;
    }
	
	public int add(int num){
		int a = num % 10;		//得到个位数
		int b = num / 10;			//得到高位数
		int sum = 0;
		while(b !=0){
			sum = sum + a;
			a = b%10;
			b = b/10;
		}
		sum = sum + a;
		return sum;
		
	}
	
	public int addDigitsO1(int num){
		if(num == 0)
			return 0;
		if(num % 9 == 0)
			return 9;
		else
			return num % 9;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoHundredFiftyEight obj = new TwoHundredFiftyEight();
		Date d1 = new Date();
		for(int i = 10000000; i < 99999999; i ++){
			obj.addDigits(i);
		}
		Date d2 = new Date();
		System.out.println(d2.getTime()-d1.getTime());
		
		Date d3 = new Date();
		for(int i = 10000000; i < 99999999; i ++){
			obj.addDigitsO1(i);
		}
		Date d4 = new Date();
		System.out.println(d4.getTime()-d3.getTime());
	}

}
