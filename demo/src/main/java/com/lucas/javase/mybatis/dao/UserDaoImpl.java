package com.lucas.javase.mybatis.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.lucas.javase.mybatis.dao.po.User;

public class UserDaoImpl implements UserDao {

	static final Log log=LogFactory.getLog(UserDao.class);
	// 注入SqlSessionFactory
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	private SqlSessionFactory sqlSessionFactory;

	public User findUserById(int id)  {
		SqlSession session = sqlSessionFactory.openSession();
		User user = null;
		try {
			// 通过sqlsession调用selectOne方法获取一条结果集
			// 参数1：指定定义的statement的id,参数2：指定向statement中传递的参数
			log.info("通过sqlsession调用test.findUserById");
			user = session.selectOne("test.findUserById", id);
			System.out.println(user);

		}catch(Exception e){
			log.error("Exception",e);
			session.rollback();
		}finally {
			//释放资源
			log.info("释放资源");
			session.close();
		}
		return user;
	}

	public void insertUser(User user)  {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			log.info("通过sqlsession调用test.insertUser");
			sqlSession.insert("test.insertUser", user);
			sqlSession.commit();
		}catch(Exception e){
			log.error("Exception",e);
			sqlSession.rollback();
		}finally {
			//释放资源
			log.info("释放资源");
			sqlSession.close();
		}

	}

}
