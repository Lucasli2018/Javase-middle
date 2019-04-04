package com.lucas.javase.jdbc.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

public class MybatisDemo {

	static final Log log=LogFactory.getLog(MybatisDemo.class);
	SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void init() throws IOException{
		try{
			//获取全局配置文件路径
			log.info("获取全局配置文件路径");
			String resource="demo/SqlMapConfig.xml";
			
			//加载资源（全局配置，其他配置，mapper.xml等）
			log.info("加载资源（全局配置，其他配置，mapper.xml等）");
			InputStream inputStream=Resources.getResourceAsStream(resource);
			
			//使用资源创建SqlSessoinFactory工厂，构建者模式
			log.info("使用资源创建SqlSessoinFactory工厂，构建者模式");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		}catch(Exception e){
			log.error("Exception",e);
		}
		
	}
	
	@Test
	public void testFindUserById(){
		//工厂方法实例化SqlSession接口
		log.info("工厂方法实例化SqlSession接口");
		SqlSession sqlSession=sqlSessionFactory.openSession();
		
		try {
			//调用SqlSession接口方法，操作数据库
			log.info("调用SqlSession接口方法，操作数据库");
			String username="ali";
			List<User> users=sqlSession.selectList("test.findUserByName", username);
			for (User user : users) {
				log.info(user);
			}
		} catch (Exception e) {
			log.error("Exception",e);
		}finally {
			//释放资源
			log.info("释放资源");
			sqlSession.close();
		}
	}
}
