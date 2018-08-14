package com.example.demo;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping(value="/index")
public class DemoController {
	
	@Value(value="${huangyuan.secret}")
	String  secret;
	@Value(value="${huangyuan.number}")
	String  number;
	
	
	
	@ResponseBody
	@RequestMapping
	public String index() { 
		return "helloworld";
	}
	@ResponseBody
	@RequestMapping(value="/get")
	public Map<String, Object> get(@RequestParam String name) {
		Map<String, Object> map=new HashMap<>();
		map.put("name", name);
		map.put("number", number);
		
		map.put("secret", secret);
		return map;
	}
	
	/*@ResponseBody
	@RequestMapping(value="/find/{id}/{name}")
	public User get(@PathVariable int id,@PathVariable String name) {
		User user=new User();
		user.setDate(new java.util.Date());
		user.setId(id);
		user.setName(name);  
		return user;
	}*/
}
