package jvm;
/**
 * @author JUANJUAN
 * @version 2017年7月24日上午9:36:34
*/
public class P340 {
	public static final int NUM=15000;
	public static int doubleValue(int i){
		for(int j =0; j <100000; j++);
		return i*2;
	}
	public static long calcSum(){
		long sum = 0;
		for(int i=1; i<=100; i++){
			sum+= doubleValue(i);
		}
		return sum;
	}
	public static void main(String[] args){
		for(int i=0; i < NUM; i++){
			calcSum();
		}
	}
	//-XX:PrintIdealGraphLevel=2 -XX:PrintIdealGraphFile=ideal.xml
	//Error: VM option 'PrintIdealGraphLevel' is develop and is available only in debug version of VM.
}
