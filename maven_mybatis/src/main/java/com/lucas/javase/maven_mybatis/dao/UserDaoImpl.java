package com.lucas.javase.maven_mybatis.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.lucas.javase.maven_mybatis.po.User;

public class UserDaoImpl implements UserDao {

	private SqlSessionFactory sqlSessionFactory;

	public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	public int insertUser(User user) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int t=0;
		try {
			t = sqlSession.insert("test.insertUser", user);
			sqlSession.commit();
		} catch (Exception e) {
			sqlSession.rollback();
		} finally {
			// 释放资源
			sqlSession.close();
		}
		return t;
	}

	public User findUserById(int id) {
		SqlSession session = sqlSessionFactory.openSession();
		User user = null;
		try {
			user = session.selectOne("test.findUserById", id);
			System.out.println(user);

		} catch (Exception e) {
			session.rollback();
		} finally {
			// 释放资源
			session.close();
		}
		return user;
	}

}
