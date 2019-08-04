package com.czxy.Druid;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import javax.sql.DataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;



public class DruidUtil {
	/**定义一个连接池*/
	private static DataSource dataSource;
	/**初始化连接池*/
	
	static{
		try {
			InputStream is = 
					DruidUtil.class.getClassLoader().getResourceAsStream("Druid.properties");
			Properties prop = new Properties();
			prop.load(is);
			dataSource = DruidDataSourceFactory.createDataSource(prop);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**通过连接池获取连接*/
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	/**关闭连接，归还资源*/
	public static void closeAll(Connection con,PreparedStatement ps,ResultSet rs) throws SQLException{
		if(rs!=null){
			rs.close();
		}
		if(ps!=null){
			ps.close();
		}
		if(con!=null){
			con.close();
		}
		
	}
}
