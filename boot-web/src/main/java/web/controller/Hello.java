package web.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {
/*	@RequestMapping({"/","/index.html"})
	public String Index() {
		
		//他会默认加上前缀templates 和后最 .html 返回视图名称
		return "login";
	}*/
	
	
	
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "helloworld";
	}
	@RequestMapping("/success")
	public String success() {
		//classpath:/templates/success.html
		return "success";
	}
}
