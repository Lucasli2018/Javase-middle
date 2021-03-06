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
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MybatisDemo {

	static final Log log=LogFactory.getLog(MybatisDemo.class);
	SqlSessionFactory sqlSessionFactory;
	
	
	@Before
	public void init() throws IOException{
		try{
			log.info("===================");
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
	
	@After
	public void teardown(){
		log.info("结束运行");
	}
	
	@Test
	public void testFindUserByName(){
		SqlSession sqlSession=null;
		try {
			//工厂方法实例化SqlSession接口
			log.info("工厂方法实例化SqlSession接口");
			sqlSession=sqlSessionFactory.openSession();
			
			//调用SqlSession接口方法，操作数据库
			log.info("调用SqlSession接口方法，操作数据库:test.findUserByName");
			String username="a";
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
	
	@Test
	public void testFindUserById(){
		SqlSession sqlSession=null;
		try {
			//工厂方法实例化SqlSession接口
			log.info("工厂方法实例化SqlSession接口");
			sqlSession=sqlSessionFactory.openSession();
			
			log.info("调用SqlSession接口方法，操作数据库:test.findUserById");
			User user=sqlSession.selectOne("test.findUserById", 4);
			log.info(user);
		} catch (Exception e) {
			log.error("Exception",e);
		}finally {
			//释放资源
			log.info("释放资源");
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteUserByName(){
		SqlSession sqlSession=null;
		try {
			//工厂方法实例化SqlSession接口
			log.info("工厂方法实例化SqlSession接口");
			sqlSession=sqlSessionFactory.openSession();
			
			log.info("调用SqlSession接口方法，操作数据库:test.deleteUserByName");
			String username="lucas&lucy";
			int r=sqlSession.delete("test.deleteUserByName", username);
			//使用select方法依然可以执行，但是会报错
			//如果没有commit提交事件，数据是不会删除的！！！
			sqlSession.commit();
			log.info("删除数据数量："+r);
		} catch (Exception e) {
			log.error("Exception",e);
			sqlSession.rollback();
		}finally{
			//释放资源
			log.info("释放资源");
			sqlSession.close();
		}
	}
	@Test
	public void testUpdateUserByName(){
		SqlSession sqlSession=null;
		try {
			//工厂方法实例化SqlSession接口
			log.info("工厂方法实例化SqlSession接口");
			sqlSession=sqlSessionFactory.openSession();
			
			log.info("调用SqlSession接口方法，操作数据库:test.updateUserById");
			User user=new User();
			user.setId(2);
			user.setUsername("lucas&lucy");
			user.setAddress("beijing");
			int r=sqlSession.update("test.updateUserById", user);//注意：这里传入的是User对象
			//使用select方法依然可以执行，但是会报错
			//如果没有commit提交事件，数据是不会删除的！！！
			sqlSession.commit();
			log.info("修改数据数量："+r);
		} catch (Exception e) {
			log.error("Exception",e);
			sqlSession.rollback();
		}finally{
			//释放资源
			log.info("释放资源");
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsertUser(){
		SqlSession sqlSession=null;
		try {
			//工厂方法实例化SqlSession接口
			log.info("工厂方法实例化SqlSession接口");
			sqlSession=sqlSessionFactory.openSession();
			
			log.info("调用SqlSession接口方法，操作数据库:test.insertUser");
			User user=new User();
			user.setUsername("lucas&lucy");
			user.setAddress("beijing");
			int r=sqlSession.insert("test.insertUser", user);//注意：这里传入的是User对象
			//使用select方法依然可以执行，但是会报错
			//如果没有commit提交事件，数据是不会删除的！！！
			sqlSession.commit();
			log.info("增加数据数量："+r);
			log.info("新增数据主键："+user.getId());
		} catch (Exception e) {
			log.error("Exception",e);
			sqlSession.rollback();
		}finally{
			//释放资源
			log.info("释放资源");
			sqlSession.close();
		}
	}
}
