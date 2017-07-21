package bases.strings;
/**
 * 该类主要测试String和StringBuffer之间的区别。
 * */
public class StringAndStringBuffer {
	/**
	 * String类追加字符串的效率
	 * 1.因为它实现字符串的串联是通过StringBuilder（或StringBuffer）的append方法实现的
	 * 	   所以效率不及StringBuilder和StringBuffer
	 * 2.String类每次赋予新值时，其对象要重新创建，耗费太多时间
	 * */
	public long getStringTime(){
		//String tempstr = "abcdefghijklmnopqrstuvwxyz";
        int times = 50000;
        long lstart1 = System.currentTimeMillis();
        @SuppressWarnings("unused")
		String str = "";
        for (int i = 0; i < times; i++) {
            str += i;
        }
        long lend1 = System.currentTimeMillis();
        long time = (lend1 - lstart1);
       
		return time;
	}
	
	/**
	 * StringBuffer类追加字符串的效率
	 */
	public long getStringBufferTime(){
		//String tempstr = "abcdefghijklmnopqrstuvwxyz";
        int times = 50000;
        long lstart2 = System.currentTimeMillis();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < times; i++) {
            sb.append(String.valueOf(i));
        }
        long lend2 = System.currentTimeMillis();
        long time = (lend2 - lstart2);
     
		return time;
	}
	/**
	 * StringBuilder类追加字符串的效率，StringBuilder不可以用于同步，适用于单线程，而StringBuffer可以用于同步，保证多线程安全。
	 */
	public long getStringBuilderTime(){
		//String tempstr = "abcdefghijklmnopqrstuvwxyz";
        int times = 50000;
        long lstart2 = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < times; i++) {
            sb.append(String.valueOf(i));
        }
        long lend2 = System.currentTimeMillis();
        long time = (lend2 - lstart2);		
		return time;
	}
	public static void main(String[] args) {
		StringAndStringBuffer sasb = new StringAndStringBuffer();
		System.out.println("String的效率："+sasb.getStringTime());
		System.out.println("StringBuffer的效率："+sasb.getStringBufferTime());
		System.out.println("StringBuilder的效率："+sasb.getStringBuilderTime());
		//当times=50000时，String的效率：49438 StringBuffer的效率：6 StringBuilder的效率：4
		//当times=5000时，String的效率：813 StringBuffer的效率：0
	}
}
