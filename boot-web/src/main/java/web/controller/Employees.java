/**
 * 
 */
package web.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.print.DocFlavor.STRING;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import web.dao.EmployeeDao;
import web.entities.Employee;

/**
 * @author huangyuan
 * @date 2018年6月21日下午6:57:01
 * @Description:员工管理
 */
@Controller
public class Employees {
	@Resource
	private EmployeeDao employeeDao;
	@GetMapping("/emps")
	public String  list() {
		Collection< Employee> employees=employeeDao.getAll();
		Map<String, Object> map = new HashMap();
		map.put("emps", employees);
		return "emp/list";
	}
}
