package com.lucas.javase.maven_mybatis.annotation;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import com.lucas.javase.maven_mybatis.po.User;

public interface UserMapper {
	@Insert("insert into user(username)values(#{username})")
	@ResultType(int.class)
	int insertUser(User user);
	
	@Select("select * from user where id=#{id}")
	@ResultType(User.class)
	User findUserById(int id);
}
