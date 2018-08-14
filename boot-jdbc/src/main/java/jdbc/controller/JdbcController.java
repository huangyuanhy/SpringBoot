/**
 * 
 */
package jdbc.controller;

import java.awt.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author huangyuan
 * @date 2018年6月27日下午8:31:05
 * @Description 数据库访问测试
 */
@org.springframework.stereotype.Controller
public class JdbcController {
	@Autowired
	JdbcTemplate template;
	@ResponseBody
	@GetMapping("/query")
	public Map<String , Object>  query() {
		 java.util.List<Map<String, Object>> queryForList = template.queryForList("select * from department");
		
		return queryForList.get(0);
	}
}
















