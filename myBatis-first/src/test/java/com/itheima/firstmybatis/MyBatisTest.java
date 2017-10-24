package com.itheima.firstmybatis;


import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itheima.pojo.User;

public class MyBatisTest {
	private SqlSessionFactory sqlSessionFactory;
	@Before
	public void init() throws IOException{
		//1.加载核心配置文件
		InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.读取配置文件内容
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		//创建sqlSessionFactory:(mybatis的核心对象,单例模式)
		sqlSessionFactory = builder.build(inputStream);
	}
	
	@Test
	public void queryUserByIdTest(){
		try {
			//1.加载核心配置文件
			InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			//2.读取配置文件内容
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			//创建sqlSessionFactory:(mybatis的核心对象,单例模式)
			SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
			//3.使用sqlSessionFactory 创建sqlSession
			SqlSession  sqlSession = sqlSessionFactory.openSession();
			//4.使用sqlSession对象调用方法执行
			Object user = sqlSession.selectOne("test.findUserById", 24);
			System.out.println(user);
			//释放资源
			sqlSession.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Test
	public void findUserLikeUsernameTest(){
		try {
			//1.加载核心配置文件
			 InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
			 //2.读取核心配置文件
			 SqlSessionFactoryBuilder  builder = new SqlSessionFactoryBuilder();
			 SqlSessionFactory sqlSessionFactory = builder.build(inputStream);
			 //3.创建sqlSession
			 SqlSession sqlSession = sqlSessionFactory.openSession();
			 //4.使用sqlSession调用方法
			 List<User> list = sqlSession.selectList("test.findUserLikeUsername", "%小明%");
			 for (User user : list) {
				 System.out.println(user);
			}
			 //5.释放资源
			 sqlSession.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void addUserTest(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
		//创建User对象
		User user = new User(3,"小橘子",new Date(),"2","大秦皇朝");
		sqlSession.insert("test.addUser", user);
		//释放资源
		sqlSession.close();
		
	}
	
	@Test
	public void insertUserTest(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
		//创建user对象
		User user = new User();
		user.setUsername("小芒果");
		user.setBirthday(new Date());
		user.setSex("1");
		user.setAddress("海南");
		sqlSession.insert("test.insertUser", user);
		//释放资源'
		sqlSession.close();
	}
	
	@Test
	public void updateUser(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
		//创建对象
		User user = new User();
		user.setUsername("小芒果和小橘子");
		user.setSex("1");
		user.setId(36);
		sqlSession.update("test.updateUser", user);
		sqlSession.close();
	}
	@Test
	public void deleteUserTest(){
		SqlSession sqlSession = this.sqlSessionFactory.openSession(true);
		sqlSession.delete("test.deleteUserById", 36);
		sqlSession.close();
	}
}
