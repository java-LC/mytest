package com.itheima.firstmybatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImp;
import com.itheima.pojo.User;

public class Mybatis {
	private SqlSessionFactory  sqlSessionFactory;
	private UserDao userDao;
	@Before
	public void inin() throws IOException{
		//1.加载配置文件
		InputStream inputStream =  Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.读取配置文件
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//创建sessiionFactory(mybatis核心对象)
		sqlSessionFactory = builder.build(inputStream);
	}
	
	
	@Test	
	public void findUerByIdTest(){
		//创建对象
		userDao = new UserDaoImp(sqlSessionFactory);
		User user = userDao.findUserById(35);
		System.out.println(user);
	}
	
	//增加用户
	@Test
	public void insertUser(){
		userDao = new UserDaoImp(sqlSessionFactory);
		User user = new User(1,"小苹果",new Date(),"1","苍山洱海");
		userDao.insertUser(user);
	}
}
