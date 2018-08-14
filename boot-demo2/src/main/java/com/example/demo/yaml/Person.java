package com.example.demo.yaml;


import java.util.Date;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
/**
 * 将配置文件的值映射过来 将本类中所有的属性和配置文件中的相关定义进行绑定
 * prefix="person" 配置文件中哪个下面的属性进行映射
 * @ConfigurationProperties 默认从全局配置文件中获取
 * @PropertySource 可以从指定具体文件
 * @author Administrator
 *只有这个组件是在容器中，才能进行绑定@Component
 *支持校验
 */
@Component
@ConfigurationProperties(prefix="person") //这个是可以的 
//@PropertySource(value= {"classpath: person.yaml"})
 
@Validated
public class Person { 
//	name必须符合邮箱格式
	@javax.validation.constraints.Email
	@Value("624119327@qq.com")
	String name;
	private Boolean boss;
	@Value("2018/1/1")
	private Date date;
	private Map<String , Object > maps;
	private List <Object> lists;
	private Dog dog;
	
	
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", boss=" + boss + ", date=" + date + ", maps=" + maps + ", lists=" + lists
				+ ", dog=" + dog + "]";
	}
	public Boolean getBoss() {
		return boss;
	}
	public void setBoss(Boolean boss) {
		this.boss = boss;
	}
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	public List<Object> getLists() {
		return lists;
	}
	public void setLists(List<Object> lists) {
		this.lists = lists;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	
}

class Dog{
	String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	String age;
}