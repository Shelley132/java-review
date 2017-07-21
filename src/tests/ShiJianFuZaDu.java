package tests;
/**
 * @author LLJ
 * @version 2017年4月23日下午12:11:31
*/
public class ShiJianFuZaDu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int n = 200;
		for(int n = 5; n < 1000000000; n*=3){
			int count =0;
			for(int i=1; i< n; i*=2){
				for(int j =1; j<i; j++){
					count++;
				}
			}
			System.out.println(n + " " +count +" " + 2*n +" "+ n * Math.log(n) );
			
		}
		
	}

}
