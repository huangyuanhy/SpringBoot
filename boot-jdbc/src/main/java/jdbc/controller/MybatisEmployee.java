/**
 * 
 */
package jdbc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jdbc.bean.Employee;
import jdbc.service.EmployeeService;

/**
 * @author huangyuan
 * @date 2018年6月28日下午6:15:14
 * @Description 对部门表测试  采用的是xml配置文件形式
 */
@RestController
public class MybatisEmployee {
	
	@Autowired
	EmployeeService emp;
	
	@GetMapping("/emp/{id}")
	public Employee getEmp(@PathVariable ("id") Integer id) {
		return emp.getEmp(id);
	}
	
	
	@GetMapping("/emp")
	public Employee updateEmp(Employee employee) {
		return emp.updateEmp(employee);
	}
}












