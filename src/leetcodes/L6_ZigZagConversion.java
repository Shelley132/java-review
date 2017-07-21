package leetcodes;

public class L6_ZigZagConversion {
	/*
	n=numRows
	Δ=2n-2    1                           2n-1                         4n-3
	Δ=        2                     2n-2  2n                    4n-4   4n-2
	Δ=        3               2n-3        2n+1              4n-5       .
	Δ=        .           .               .               .            .
	Δ=        .       n+2                 .           3n               .
	Δ=        n-1 n+1                     3n-3    3n-1                 5n-5
	Δ=2n-2    n                           3n-2                         5n-4
	
	*/
		public String convert(String s, int numRows) {
		    if(numRows<=1)return s;
		    //这个zigzag有几行，就创建一个大小为几的StringBuffer数组。然后向StringBuffer添加字符。
		    StringBuilder[] sb=new StringBuilder[numRows];
		    //初始化所有的StringBuffer为空串。
		    for(int i=0;i<sb.length;i++){
		        sb[i]=new StringBuilder("");   //init every sb element **important step!!!!
		    }
		    int incre=1;
		    int index=0;
		    for(int i=0;i<s.length();i++){
		    	//从0开始，正数StringBuffer
		        sb[index].append(s.charAt(i));
		        if(index==0){incre=1;}
		        //到达n之后，就开始倒数StringBuffer
		        if(index==numRows-1){incre=-1;}
		        index+=incre;
		    }
		    //字符串这么拼接开销太大了？
		    String re="";
		    for(int i=0;i<sb.length;i++){
		        re+=sb[i];
		    }
		    return re.toString();
		}
	
	public static void main(String[] args){
		String s = "PAYPALISHIRING";
		L6_ZigZagConversion six = new L6_ZigZagConversion();
		System.out.println(six.convert(s, 3));
		
	}
}
