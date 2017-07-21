package tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 刘利娟 liulijuan132@gmail.com
 * @version 创建时间:2014年1月5日 下午10:50:01
 * 类说明：
 */
public class JDBCTools {
	// 定义数据库操作的常量、对象
	// 数据库驱动程序
	private final String DBDRIVER = "oracle.jdbc.driver.OracleDriver";
	// 数据库连接地址
	private final String DBURL = "jdbc:oracle:thin:@49.140.99.181:1521:orcl";
	// 数据库用户名
	private final String DBUSER = "test01";
	// 数据库连接密码
	private final String DBPASSWORD = "test01";
	// 声明一个数据库连接对象
	private Connection conn = null;
	private ArrayList<String[]> aList = null;
	private Statement stmt = null;

	// 在构造方法之中连接数据库
	public JDBCTools() {
		try {
			// 加载驱动程序
			Class.forName(DBDRIVER);
			//System.out.println("驱动已加载");
			// 连接数据库
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
			//System.out.println("数据库已连接");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// 返回一个数据库连接
	public Connection getConnection() {
		// / 返回连接对象
		return this.conn;
	}
	// 关闭数据库连接
	public void close() {
		try {
			this.conn.close();
			//System.out.println("驱动已关闭");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 更新数据库中的数据
	 * 
	 * 包括插入（insert）、修改（update）、删除（delete）
	 * 
	 * 当返回值为0时，表示执行失败；当返回值大于0时，即更新的行数，执行成功
	 * */
	public int updateInfo(String sql) {
		try {
			stmt = this.getConnection().createStatement();
			int result = stmt.executeUpdate(sql);
			stmt.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return 0;
	}

	/**
	 * 该方法对数据库进行查询操作
	 * 
	 * @param sql String
	 *            SQL语句
	 * @return ArrayList<String[]> 返回值为查询到的记录
	 * */
	public ArrayList<String[]> queryInfo(String sql) {
		aList = new ArrayList<String[]>();
		try {
			stmt = this.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			ResultSetMetaData rsmd = rs.getMetaData();

			int columnCount = rsmd.getColumnCount();

			String[] columns = new String[columnCount];
			for (int i = 0; i < columnCount; i++) {
				columns[i] = rsmd.getColumnName(i + 1);
			}

			while (rs.next()) {
				// 创建了一个字符串数组，infos，用来暂时存储每一行的记录
				String[] infos = new String[columnCount];
				for (int i = 0; i < columnCount; i++) {
					infos[i] = rs.getString(columns[i]);
				}
				aList.add(infos);				
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		close();
		return aList;
	}
	/**
	 * 该方法对数据库进行查询操作
	 * 
	 * @param sql String 
	 *            SQL语句
	 * @param nowPage Integer
	 *            当前要查询的页码
	 * @return ArrayList<String[]> 返回值为查询到的记录
	 * */
	public ArrayList<String[]> queryInfo(String sql, int nowPage) {
		aList = new ArrayList<String[]>();
		try {
			stmt = this.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			ResultSetMetaData rsmd = rs.getMetaData();

			int columnCount = rsmd.getColumnCount();

			String[] columns = new String[columnCount];
			for (int i = 0; i < columnCount; i++) {
				columns[i] = rsmd.getColumnName(i + 1);
			}

			for (int i = 0; i < (nowPage - 1) * 10; i++) {
				rs.next();
			}
			for (int i = (nowPage - 1) * 10; i < nowPage * 10; i++) {
				rs.next();
				// 创建了一个字符串数组，infos，用来暂时存储每一行的记录
				String[] infos = new String[columnCount];
				for (int j = 0; j < columnCount; j++) {
					infos[j] = rs.getString(columns[j]);
				}
				aList.add(infos);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		close();
		return aList;
	}

	/**
	 * 该方法对数据库进行批量操作
	 * 
	 * @param sql
	 *            String[] 多条SQL语句
	 * @return boolean 返回值为true，则批量操作成功 返回值为false，则批量操作失败
	 * */
	public boolean batchInfo(String[] sql) {
		boolean bBatch = true;
		try {
			conn = this.getConnection();
			conn.setAutoCommit(false);
			stmt = conn.createStatement();			
			for (int i = 0; i < sql.length; i++) {
				stmt.addBatch(sql[i]);
			}
			stmt.executeBatch();
			
			conn.commit();
			stmt.close();			
		} catch (Exception e) {	
			e.printStackTrace();
			try {
				conn.rollback();
				stmt.close();	
				bBatch = false;
			} catch (SQLException e1) {
				e1.printStackTrace();
			}			
		}
		close();
		return bBatch;
	}
	public List<Map<String,Object>> query(String sql,Object[] objs){
		ArrayList<Map<String,Object>> list = new ArrayList<Map<String,Object>>();//存储多行记录(Map)用的集合
		try {
			PreparedStatement ps = getConnection().prepareStatement(sql);
			ParameterMetaData pmd = ps.getParameterMetaData();//获得预处理语句对象中的参数模型（参数的个数、类型等等）
			int count = pmd.getParameterCount();//获得ps对象中的参数个数
			for(int i = 0 ; i < count ; i++){
				ps.setObject(i+1, objs[i]);
			}
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			count = rsmd.getColumnCount();//结果集中的字段个数
			while(rs.next()){
				Map<String,Object> map = new HashMap<String,Object>();
				for(int i = 0 ; i < count ; i++){
					String key = rsmd.getColumnName(i+1);
					Object value = rs.getObject(key);
					map.put(key, value);
					System.out.println(key+","+value);
				}
				list.add(map);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return list;
	}

	public Map<String,Object> getOneRow(String sql)
	{
		//执行下面的queryToList方法
		List<Map<String,Object>> list=query(sql,new Object[]{});
		//三目运算，查询结果list不为空返回list中第一个对象,否则返回null
		return list.size()>0?list.get(0):null;
	}
	public boolean uploadBlob(String userid,String filepath){
		conn = this.getConnection();
		Statement st = null;
		try {
			conn.setAutoCommit(false);
			st = conn.createStatement();		
			ResultSet rs = st.executeQuery("select userphoto from　userphoto　where　userid="+userid+" for update");
			if (rs.next()) {
				//得到java.sql.Blob对象，然后Cast为oracle.sql.BLO
				oracle.sql.BLOB blob = (oracle.sql.BLOB) rs.getBlob(1);	
				//到数据库的输出流
				@SuppressWarnings("deprecation")
				OutputStream outStream = blob.getBinaryOutputStream();
				//这里用一个文件模拟输入流
				File file = new File(filepath);
				InputStream fin = new FileInputStream(file);
				//将输入流写到输出流
				byte[] b = new byte[blob.getBufferSize()];
				int len = 0;
				while ( (len = fin.read(b)) != -1) {
				outStream.write(b, 0, len);
				}		
			//依次关闭（注意顺序）		　　
				fin.close();
				outStream.flush();
				outStream.close();
			}else{
				st.executeUpdate("insert into userphoto　values("+userid+",empty_blob())");
				rs = st.executeQuery("select userphoto from　userphoto　where　userid="+userid+" for update");
				if (rs.next()) {
					//得到java.sql.Blob对象，然后Cast为oracle.sql.BLO
					oracle.sql.BLOB blob = (oracle.sql.BLOB) rs.getBlob(1);	
					//到数据库的输出流
					@SuppressWarnings("deprecation")
					OutputStream outStream = blob.getBinaryOutputStream();
					//这里用一个文件模拟输入流
					File file = new File(filepath);
					InputStream fin = new FileInputStream(file);
					//将输入流写到输出流
					byte[] b = new byte[blob.getBufferSize()];
					int len = 0;
					while ( (len = fin.read(b)) != -1) {
					outStream.write(b, 0, len);
					}		
				//依次关闭（注意顺序）		　　
					fin.close();
					outStream.flush();
					outStream.close();
				}
			}
			conn.commit();
			st.close();
			close();
		}catch (Exception e){
			e.printStackTrace();
			close();
			return false;
		}		
		return true;
	}
	
	public String getPhoto(String userid){
		conn = this.getConnection();
		Statement st = null;
		String path = "D://images/"+userid+".jpg";
		try {
			conn.setAutoCommit(false);
			st = conn.createStatement();		
			ResultSet rs = st.executeQuery("select userphoto from　userphoto　where　userid="+userid);
			if (rs.next()) {
				//得到java.sql.Blob对象，然后Cast为oracle.sql.BLO
				oracle.sql.BLOB blob = (oracle.sql.BLOB) rs.getBlob(1);	
				InputStream ins = blob.getBinaryStream();
				
				File file = new File(path);
				OutputStream fout = new FileOutputStream(file);
				//下面将BLOB数据写入文件			
				byte[] b = new byte[1024];
				
				int len = 0;
				
				while ( (len = ins.read(b)) != -1) {
					fout.write(b, 0, len);	
				}		
			//依次关闭（注意顺序）		
				fout.close();
				ins.close();				
			}
			conn.commit();
			st.close();
			close();
		}catch (Exception e){
			e.printStackTrace();
			close();
			return null;
		}		
		
		return path;
	}
}
