package com.lucas.javase.mybatis.annotation;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.lucas.javase.mybatis.dao.po.User;

public class AllTests {
	
	static final Log log=LogFactory.getLog(AllTests.class);
	SqlSessionFactory sqlSessionFactory;
	
	@Before
	public void startUp() throws IOException{
		try {
			//全局配置路径
			log.info("全局配置路径");
			String resource="annotation/SqlMapConfig.xml";
			
			//加载配置文件
			log.info("加载配置文件");
			InputStream inputStream=Resources.getResourceAsStream(resource);
			
			//构建者模式获取SqlSessionFactory
			log.info("构建者模式获取SqlSessionFactory");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
		} catch (Exception e) {
			log.error("Exception",e);
		}
		
	}

	@Test
	public void testFindUserById(){
		//获取SqlSession
		log.info("获取SqlSession");
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			UserMapper mapper=sqlSession.getMapper(UserMapper.class);
			User user=mapper.findUserById(4);
			log.info(user);
		} catch (Exception e) {
			log.error("Exception",e);
		}
		
		//数据库操作
		log.info("数据库操作");
		
		//释放
		log.info("释放");
	}
	
	@Test
	public void testInsertUser(){
		//获取SqlSession
		log.info("获取SqlSession");
		SqlSession sqlSession=sqlSessionFactory.openSession();
		try {
			UserMapper mapper=sqlSession.getMapper(UserMapper.class);
			User user=new User();
			user.setAddress("北京");
			user.setBirthday("2019-02-20");
			user.setSex("男生");
			user.setUsername("詹丹");
			int r=mapper.insertUser(user);
			sqlSession.commit();
			log.info("插入数据数量："+r);
		} catch (Exception e) {
			log.error("Exception",e);
		}
		
		//数据库操作
		log.info("数据库操作");
		
		//释放
		log.info("释放");
	}
}
