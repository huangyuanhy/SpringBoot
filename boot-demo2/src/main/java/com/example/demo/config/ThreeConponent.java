/**
 * 
 */
package com.example.demo.config;

import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.ServletRegistration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.conponent.MyListener;
import com.example.demo.conponent.MyServlet;
import com.example.demo.conponent.Myfilter;

/**
 * @author huangyuan
 * @date 2018年6月23日下午4:51:40
 * @Description: 三大组件的配置 servlet filter listener
 */
@Configuration
public class ThreeConponent {
	@Bean
	public ServletRegistrationBean<MyServlet> myServlet(){
		//指定映射路径由那个servlet处理 默认web启动时  servlet初始化 所以下面这句话会打印
		System.out.println("myservlet.........");
		return new ServletRegistrationBean<MyServlet>(new MyServlet(), "/MyServlet");
	}
	
	//注册过滤器
	@Bean
	public FilterRegistrationBean<Myfilter> myfilter(){
		FilterRegistrationBean<Myfilter> filterRegistrationBean = new FilterRegistrationBean<Myfilter>();
		filterRegistrationBean.setFilter(new Myfilter());
		filterRegistrationBean.setUrlPatterns(Arrays.asList("/MyServlet"));
		return filterRegistrationBean;
		
	}
	//注册监听器
	@Bean
	public ServletListenerRegistrationBean<MyListener> mylistener(){
		return new ServletListenerRegistrationBean<MyListener>(new MyListener());
	}
}



























