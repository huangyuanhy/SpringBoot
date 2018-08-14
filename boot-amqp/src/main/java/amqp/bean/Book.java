/**
 * 
 */
package amqp.bean;

import java.io.Serializable;

/**
 * @author huangyuan
 * @date 2018年7月1日下午8:57:28
 * @Description  bean
 */
public class Book {
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public Book() {
		
	}
	public Book(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
}
