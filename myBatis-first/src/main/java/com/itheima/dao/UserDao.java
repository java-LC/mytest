package com.itheima.dao;

import com.itheima.pojo.User;

public interface UserDao {
	//根据id查询用户
	public  User findUserById(Integer id);
	//新增用户
	public void insertUser(User user);
}
