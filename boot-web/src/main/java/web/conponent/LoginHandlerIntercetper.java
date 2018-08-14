/**
 * 
 */
package web.conponent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author huangyuan
 * @date 2018年6月21日下午1:13:47
 * Description: 登陆权限检查
 */
public class LoginHandlerIntercetper implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		Object username = request.getSession().getAttribute("username");
		if (username==null) {
			//未登录 转发
			request.setAttribute("msg", "用户未登陆");
			request.getRequestDispatcher("/index.html").forward(request,response);
			return false;
			
		}else {
			//放行
			return true;
		}
		
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}


}
