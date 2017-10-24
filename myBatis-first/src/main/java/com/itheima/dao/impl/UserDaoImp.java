package com.itheima.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;

public class UserDaoImp implements UserDao {
	private SqlSessionFactory sqlSessionFactory;
	public UserDaoImp() {
		super();
	}
	public UserDaoImp(SqlSessionFactory sqlSessionFactory){
		super();
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	

	@Override
	public User findUserById(Integer id) {
		//创建sqlSession
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		System.out.println(sqlSession+"--------");
		User user = sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return user;
	}
	
	//添加用户
	@Override
	public void insertUser(User user) {
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
	//	User user2 = new User(1,"小苹果",new Date(),"2","楚国");
		sqlSession.insert("test.addUser", user);
		sqlSession.close();
		
	}

}
