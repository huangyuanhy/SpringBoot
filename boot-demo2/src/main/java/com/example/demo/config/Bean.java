package com.example.demo.config;

import org.springframework.context.annotation.Configuration;

import com.example.demo.user.User;

/**
 * 不在采用xml方式的配置文件添加bean
 * 而是采用注解方式
 * @author Administrator
 *@Configuration告诉boot这个类是个配置类，代替之前的配置文件
 *
 */
@Configuration
public class Bean {
	//将方法的返回值添加到容器中 其默认id就是方法名
	@org.springframework.context.annotation.Bean
	public User hello() {
		System.out.println("配置类给容器中添加组件了");
		return new User();
	}
}
