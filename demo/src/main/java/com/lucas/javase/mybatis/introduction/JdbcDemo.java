package com.lucas.javase.mybatis.introduction;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;

/**
 * 回顾JDBC代码
 * 
 * @author think
 *
 */
public class JdbcDemo {
	
	private static final String DRIVER="jdbc:mysql://192.100.99.185:3306/casco_db?characterEncoding=utf-8";
	private static final String USERNAME="casco_user";
	private static final String PASSWORD="cascopass";

	@Test
	public void test() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		Log log=LogFactory.getLog(JdbcDemo.class);
		try {
			// 加载数据库驱动
			log.info("加载数据库驱动");
			Class.forName("com.mysql.jdbc.Driver");

			// 通过驱动管理类获取数据库链接connection = DriverManager
			log.info("通过驱动管理类获取数据库链接connection = DriverManager");
			connection = DriverManager.getConnection(DRIVER,USERNAME,PASSWORD);

			// connection.setAutoCommit(false);

			// 定义sql语句 ?表示占位符
			log.info("定义sql语句 ?表示占位符");
			//String sql = "select * from user where username = ?";
			String sql = "select * from user";
			// 获取预处理 statement
			preparedStatement = connection.prepareStatement(sql);

			// 设置参数，第一个参数为 sql 语句中参数的序号（从 1 开始），第二个参数为设置的值
			log.info("设置参数，第一个参数为 sql 语句中参数的序号（从 1 开始），第二个参数为设置的值");
			//preparedStatement.setString(1, "lucas");
			// 向数据库发出 sql 执行查询，查询出结果集
			log.info("向数据库发出 sql 执行查询，查询出结果集");
			resultSet = preparedStatement.executeQuery();
			// 遍历查询结果集
			while (resultSet.next()) {
				System.out.println(resultSet.getString("id") + " " + resultSet.getString("username"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 释放资源
			if (resultSet != null) {
				try {
					resultSet.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (preparedStatement != null) {
				try {
					preparedStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block e.printStackTrace();
				}
			}
		}

	}
}
