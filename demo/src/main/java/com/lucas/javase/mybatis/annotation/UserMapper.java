package com.lucas.javase.mybatis.annotation;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.lucas.javase.mybatis.dao.po.User;

public interface UserMapper {
	@Select("select * from user where id=#{id}")
	public User findUserById(int id) ;
	@Insert("insert into user(username,sex,birthday,address)values(#{username},#{sex},#{birthday},#{address})")
	@SelectKey(before = false, keyProperty = "id", resultType = int.class, statement = { "select last_insert_id()" })
	public int insertUser(User user) ;
}
