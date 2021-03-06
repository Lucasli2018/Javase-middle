package com.lucas.javase.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;


public class JdbcDemo {
	
	static final Log log=LogFactory.getLog(JdbcDemo.class);
	static final String DRIVER="com.mysql.jdbc.Driver";
	static final String DATABASE="jdbc:mysql://192.100.99.185:3306/casco_db?characterEncoding=utf-8";
	static final String USERNAME="casco_user";
	static final String PASSWORD="cascopass";

	@Test
	public void testFindUserById() throws Exception{
		Connection conn=null;
		try{
			//加载数据库驱动
			log.info("加载数据库驱动");
			Class.forName(DRIVER);
			//使用驱动建立连接
			log.info("使用驱动建立连接");
			conn=DriverManager.getConnection(DATABASE, USERNAME, PASSWORD);
			
			//预处理sql
			String sql="select * from user where id = ?";
			log.info("预处理sql");
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, "34");
			//ps.setInt(1, 1);
			
			//执行操作
			log.info("执行操作");
			ResultSet rs=ps.executeQuery();
			
			//遍历输出
			while(rs.next()){
				log.info(rs.getString("id")+" "+rs.getString("username"));
			}
		}catch(Exception e){
			log.error("Exception",e);
		}finally{
			//释放资源
			log.info("释放资源");
			conn.close();
		}
	}
}
