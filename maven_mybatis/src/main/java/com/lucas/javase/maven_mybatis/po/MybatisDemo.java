package com.lucas.javase.maven_mybatis.po;

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

import com.lucas.javase.maven_mybatis.po.User;

public class MybatisDemo {

	static final Log log = LogFactory.getLog(MybatisDemo.class);
	final String resource = "introduction/SqlMapConfig.xml";
	SqlSessionFactory sqlSessionFactory;

	@Before
	public void before() throws IOException {
		log.info("指定全局配置文件");
		InputStream inputStream = Resources.getResourceAsStream(resource);
		log.info("加载所有配置文件");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserById() {
		log.info("创建SqlSession");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		log.info("调用SqlSession的接口方法");
		User user = sqlSession.selectOne("test.findUserById", 1);
		log.info(user);
		log.info("释放资源");
		sqlSession.close();
	}
	@Test
	public void testInsertUser() {
		log.info("创建SqlSession");
		SqlSession sqlSession = sqlSessionFactory.openSession();
		log.info("调用SqlSession的接口方法");
		User user=new User(2, "ll");
		int r = sqlSession.insert("test.insertUser",user);
		
		//千万记得一定要commit
		sqlSession.commit();
		log.info("插入数据数量："+r);
		log.info("释放资源");
		sqlSession.close();
	}
}
