package web.controller;


import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 处理登陆请求
 * @author Administrator
 *
 */

@Controller
public class Login {
	@PostMapping("/user/login")
	public String login(@RequestParam("username")String username,
						@RequestParam("password")String password,
						Map<String, String > map,HttpSession session) {
		if (!StringUtils.isEmpty(username)&& "123456".equals(password)) {
			//登陆成功 为防止表单重复提交可以使用重定向   main.html又进行了视图映射最总还是访问dashboard。HTML页面
			//return "dashboard";
			//表示用户已经登陆
			session.setAttribute("username", username);
			return "redirect:/main.html" ;
		}else {
			map.put("msg", "密码错误");
			return "login";
		}
	}
}
