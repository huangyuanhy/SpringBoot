/**
 * 
 */
package com.example.demo.conponent;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author huangyuan
 * @date 2018年6月24日上午11:17:05
 * @Description:
 */
public class MyListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("web app is destroyed");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("web app is initialized");
	}

}
