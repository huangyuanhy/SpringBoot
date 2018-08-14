package web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import web.conponent.LoginHandlerIntercetper;
import web.conponent.MyLocaleResolver;
@Configuration
public class MyConfig extends WebMvcConfigurationSupport{

	@Override
	protected void addViewControllers(ViewControllerRegistry registry) {
		//实现逻辑视图的跳转，这里是直接重写的方法，如果是自定义的方法，一定要在方法名上声明@bean ，这样才能注入进容器中
		//将静态资源public resource static 下的相关文件映射到templates 下
		registry.addViewController("/").setViewName("login");
		registry.addViewController("/index.html").setViewName("login");
		//使用重定向防止表单重复提交
		registry.addViewController("/main.html").setViewName("dashboard");
	}
	
	
	//添加静态资源文件，外部可以直接访问地址
/*	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
*/


	//如果我们在容器中注册了LocaleResolver，那么就是使用我们自己定义的，否则使用默认的
	@Bean
	public LocaleResolver localeResolver() {
		return new MyLocaleResolver();
	}
	//拦截器    对于静态资源已经boot已经做好了放行
/*	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginHandlerIntercetper()).addPathPatterns("/**")
		.excludePathPatterns("/","/index.html","/user/login");
	}
	*/
}
