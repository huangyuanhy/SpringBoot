package web.conponent;



import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.StringUtils;



/**
 * 在连接上收订携带区域信息，供解析，确定浏览器是什么语言
 * @author Administrator
 *
 */
public class MyLocaleResolver implements org.springframework.web.servlet.LocaleResolver{

	@Override
	public Locale resolveLocale(HttpServletRequest request) {
		String language=request.getParameter("l");
		Locale locale=null;
		//携带了区域信息 ，则按照指定的语言
		//否则按照默认的区域信息
		locale=Locale.getDefault();
		if (!StringUtils.isEmpty(language)) {
			String[] split = language.split("_");
			locale=new Locale(split[0], split[1]);
		}

		return locale;
	}

	@Override
	public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
		// TODO Auto-generated method stub

	}


}
