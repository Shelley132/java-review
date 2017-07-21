package threads;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author LLJ
 * @version 2017年4月12日下午10:02:35
*/
public class P277Enum {

	public enum EnumSingleton{
		connectionFactory;
		private Connection connection;
		private EnumSingleton(){
			
			try {
				String url = "jdbc:mysql://localhost:3306/forum";
				String username ="root";
				String password = "mysql";
				String driverName = "com.mysql.jdbc.Driver";
				Class.forName(driverName);
				connection = DriverManager.getConnection(url,username, password);
				
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public Connection getConnection(){
			return connection;
		}
		
	}
	public static Connection getConnection(){
		return EnumSingleton.connectionFactory.getConnection();
	}
	
	public static void main(String[] args) {
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for(int  i=0; i< 5; i++){
					System.out.println(P277Enum.getConnection().hashCode());
				}
			}
			
		}).start();
	}
}
