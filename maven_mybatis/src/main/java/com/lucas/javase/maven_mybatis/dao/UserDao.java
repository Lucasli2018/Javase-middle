package com.lucas.javase.maven_mybatis.dao;

import com.lucas.javase.maven_mybatis.po.User;

public interface UserDao {
	int insertUser(User user);
	User findUserById(int id);
}
