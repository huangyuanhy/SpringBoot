package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


import com.example.demo.yaml.Person;



@RunWith(SpringRunner.class)
@SpringBootTest
public class BootDemo1ApplicationTests {
	
	//日志记录相关  获取其实现类
	Logger logger=LoggerFactory.getLogger(getClass());
	
	
	@Autowired
	Person person ;
	@Test
	public void contextLoads() throws Exception {
		System.out.println(person); 
		
		//日志的使用  其级别由低到高  可以调整日志输出级别，boot 默认是info级别
		logger.trace("trace 日志");
		logger.debug("debug 日志");
		logger.info("trace 日志");
		logger.warn("warn 日志");
		logger.error("error 日志");
	}
	
	@Autowired
	ApplicationContext ioc;
	//测试bean是否注入
	@Test
	public void testUser() {
		boolean b = ioc.containsBean("hello");
		System.out.println(b);
	}
	
	

	
}
















