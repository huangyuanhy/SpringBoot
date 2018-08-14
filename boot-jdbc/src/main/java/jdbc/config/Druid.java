/**
 * 
 */
package jdbc.config;



import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/**
 * @author huangyuan
 * @date 2018年6月27日下午9:16:56
 * @Description 配置Druid数据源的相关属性
 */
@Configuration
public class Druid {
	@ConfigurationProperties(prefix="spring.datasource")
	@Bean
	public DataSource durid() {
		return new DruidDataSource() ;
	}
	
	//配置druid后台管理
	
	//1配置一个管理的servlet
	@Bean
	public ServletRegistrationBean state(){
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
		Map<String, String> map=new HashMap<>();
		map.put("loginUsername", "admin");
		map.put("loginPassword", "925925");
		map.put("allow", "");//默认访问所有
		servletRegistrationBean.setInitParameters(map);
		return servletRegistrationBean;
		
		
	}
	
	//配置一个web监控的filter
	@Bean
	public FilterRegistrationBean filter(){
		FilterRegistrationBean bean=new FilterRegistrationBean();
		bean.setFilter(new WebStatFilter());
		Map<String, String> map=new HashMap<>();
		map.put("exclusions", "*.js,*.css,/druid/*");
		bean.setInitParameters(map);
		bean.setUrlPatterns(Arrays.asList("/*"));
		return bean;
	}
}
