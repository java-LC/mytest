package cn.itcast.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		//运行Springboot的应用
		//SpringApplication.run(Application.class, args);

		//创建Springboot应用
		SpringApplication springApplication = new SpringApplication(Application.class);
		//关闭Spring广告
		springApplication.setBannerMode(Banner.Mode.OFF);
		//运行Springboot
		springApplication.run(args);
		
		
	}
}
