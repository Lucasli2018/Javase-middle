package com.lucas.javase.mybatis.dao.test;


import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.lucas.javase.mybatis.dao.UserDao;
import com.lucas.javase.mybatis.dao.UserDaoImpl;
import com.lucas.javase.mybatis.dao.po.User;


public class UserDaoTest {

	private SqlSessionFactory sqlSessionFactory;
	static final Log log=LogFactory.getLog(UserDaoTest.class);

	@Before
	public void before() {
		try {
			// 指定全局配置文件路径
			log.info("=================");
			log.info("指定全局配置文件路径");
			String resource = "dao/SqlMapConfig.xml";
			// 加载资源文件（全局配置文件和映射文件）
			log.info("加载资源文件（全局配置文件和映射文件）");
			InputStream inputStream = Resources.getResourceAsStream(resource);
			// 还有构建者模式，去创建SqlSessionFactory对象
			log.info("构建者模式，去创建SqlSessionFactory对象");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testFindUserById() {
		log.info("接口注入sqlSessionFactory");
		UserDao dao = new UserDaoImpl(sqlSessionFactory);
		User user = dao.findUserById(4);
		log.info(user);
	}

	@Test
	public void testInsertUser() {
		log.info("接口注入sqlSessionFactory");
		UserDao dao = new UserDaoImpl(sqlSessionFactory);
		User user = new User();
		user.setUsername("老郭");
		user.setSex("男");
		user.setAddress("致真大厦");
		user.setBirthday("2019-02-02");
		// 调用dao的添加用户操作
		dao.insertUser(user);
		// 打印通过主键返回策略生成的ID
		log.info("新增的数据主键："+user.getId());
	}

}
