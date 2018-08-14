/**
 * 
 */
package jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GeneratorType;

/**
 * @author huangyuan
 * @date 2018年6月28日下午6:54:23
 * @Description 实体类 与数据库中的字段一一对应
 */
@Entity //使用jpa注解配置映射关系
@Table(name="user") //和user表相对应  如果省略不写 默认表名就是类名首字母小写  即user  
public class User {
	@Id //这是个主键
	@GeneratedValue(strategy=GenerationType.IDENTITY)//自增主键
	private Integer id;
	
	@Column(name="name",length=50)
	 private String name;
	//如果不写，默认就是字段和列名一致
	 private String email;
	 public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
