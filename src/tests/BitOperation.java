package tests;
/**
 * @author LLJ
 * @version 2017年3月8日下午9:43:16
*/
public class BitOperation {

	public int func( int v){
		v^=v>>16;
		v^=v>>16;
		v^=v>>16;
		v&=0xf;
		return (0x6996>>v)&1;
	}
	
	public int funb(int n){
		int t = 1<<n;
		int val = 0;
		for(int i = 0; i <t; ++i){
			val+=func(i);
		}
		return val;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new BitOperation().funb(10));
	}

}
