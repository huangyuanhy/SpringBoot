/**
 * 
 */
package jpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jpa.entity.User;
import jpa.repository.UserRepository;

/**
 * @author huangyuan
 * @date 2018年6月28日下午7:15:08
 * @Description 测试jpa 操作数据库
 */
@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;  //自动注入 这个接口
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable ("id") Integer id) {
		Optional<User> findById = userRepository.findById(id);
		return findById.get();
	}
	
	@GetMapping("/user")
	public User inserUser(User user) {
		return userRepository.save(user);
	}
	//查询所有
	@GetMapping("getAll")
	public List<User> getUser(){
		 return userRepository.findAll();
	}
}
