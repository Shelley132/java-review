package com.cn.llj.tools;
/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年1月5日 下午10:51:19
 * 类说明：
 */
public class Test {

	public static void main(String[] args) {
		JDBCTools tool = new JDBCTools();
		String[][] infos = {
			/*	{"7654", "MARTIN", "SALESMAN", "7698", "1981-9-28", "1250.00", "1400.00", "30"},
				{"7698", "BLAKE", "MANAGER", "7839", "1981-5-1", "2850.00", "0", "30"},
				{"7782", "CLARK", "MANAGER", "7839", "1981-6-9", "2450.00", "0", "10"},
				{"7788", "SCOTT", "ANALYST", "7566", "1987-4-19", "3000.00", "0", "20"},
				{"7839", "KING", "PRESIDENT", "7566", "1981-11-17", "5000.00", "0", "10"},
				{"7844", "TURNER", "SALESMAN", "7698", "1981-9-8", "1500.00", "0.00", "30"},*/
			  {"7876","ADAMS","CLERK","7788","1987-5-31","1100.00","NULL","20"},  
			/*	 7900 JAMES      CLERK      7698 1981-12-3      950.00               30  
				 7902 FORD       ANALYST    7566 1981-12-3     3000.00               20  
				 7934 MILLER     CLERK      7782 1982-1-23     1300.00               10 */
		};
		String[] sqls = new String[infos.length];
		for(int i = 0 ; i < infos.length ; i ++){
			String[] info = infos[i];
			sqls[i] = "insert into emp values("+info[0]+",'"+info[1]+"','"+info[2]+"',"+info[3]+",to_date('"+info[4]+"','yyyy-mm-dd'),"+info[5]+","+info[6]+","+info[7]+")";			
		}
		tool.batchInfo(sqls);

	}

}
