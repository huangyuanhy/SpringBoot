/**
 * 
 */
package other.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import other.service.HelloService;

/**
 * @author huangyuan
 * @date 2018年7月4日下午2:26:43
 * @Description
 */
@RestController
public class Hello {
	@Autowired
	HelloService helloService;
	@RequestMapping("hello")
	public String  hello() {
		//下面会单独开启一个线程执行
		helloService.hello();
		return "string";
	}
}
