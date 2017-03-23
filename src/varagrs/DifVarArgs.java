package varagrs;

public class DifVarArgs {
//String... 其实和String[]是一样的处理方式，只是形式不同而已。但是String...可以使用几个String来调用，而String[]则只能使用字符串数组形式来调用
	
	
	public void callM1(String[] args){
		System.out.println(args.getClass()==String[].class);
		for(String s:args){
			System.out.println(s);
		}
	}
	
	public void callM2(String... args){
		
		System.out.println(args.getClass()==String[].class);
		for(String s :args){
			System.out.println(s);
		}
	}
	
	public static void main(String[] args){
		DifVarArgs test = new DifVarArgs();
		test.callM1(new String[]{"a","b","c"});
		test.callM2("a","b","c");
		
		/*true
		a
		b
		c
		true
		a
		b
		c*/
	}
}
