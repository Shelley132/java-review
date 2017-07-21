package leetcodes;
/**
 * 位操作可以干哪些事？
 * 1.二进制数中1的个数
 * 2.不用加减符号实现加法（不用乘除符号实现除法）
 * 3.异或检测单身狗
 * @author LLJ
 * @version 2017年4月25日上午10:01:34
*/
public class BitOperation {

	
	/**
	 * 不用加减法实现加法
	 * @author LLJ
	 * @version 2017年4月25日上午10:42:29
	 * @param a
	 * @param b
	 * @return
	 */
	public static int add(int a, int b){
		/**
		 * &可以得到是否进位
		 *  101
		 * &111
		 * ————
		 *  101
		 * */
		int x = a&b;
		//递归出口，就是没有任何一位有进位
		if(x==0){
			return a|b;
		}else{
			//有进位的话，就要移位
			x<<=1;
			/**
			 * ^可以得到本位
			 *  101
			 * ^111
			 * ————
			 *  010
			 * */
			int y=a^b;	//异或可以得到本位
			return add(x, y);
		}
	}
	
	/**
	 * 暴力求解a/b，每次a-b，直到a<b，减的次数就是商
	 * @author LLJ
	 * @version 2017年4月25日上午10:29:58
	 * @param a
	 * @param b
	 * @return
	 */
	public static int div(int a, int b){
		int ans =0;
		while(a>=b){
			a-=b;
			ans++;
		}
		return ans;
	}
	/**
	 * 增大减的数
	 * @author LLJ
	 * @version 2017年4月25日上午10:32:17
	 * @param a
	 * @param b
	 * @return
	 */
	public static int div_1(int a, int b){
		int ans =0,x,y;
		while(a>=b){
			x=b;
			y=1;
			while(a-x>=x){
				//x和y同时扩大一倍
				x+=x;
				y+=y;
			}
			a-=x;
			ans+=y;
		}
		return ans;
	}
	
	/**
	 * 不用乘除法实现除法，高效的实现
	 * @author LLJ
	 * @version 2017年4月25日上午10:29:07
	 * @param a
	 * @param b
	 * @return
	 */
	public static int div_2( int a, int b){
	    int x,y;
	    int ans=0;
	    while(a>=b){
	        x=b;
	        y=1;
	        while(a>=(x<<1)){
	        	//x和y同时扩大2倍，直到x大于a
	            x<<=1;        
	            y<<=1;      
	        }
	        a-=x;
	        ans+=y;
	    }
	    return ans;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(div(100,3));
		System.out.println(div_1(100,3));
		System.out.println(div_2(100,3));
		System.out.println(add(2,-3));
		System.out.println(add(5,9));
	}

}
