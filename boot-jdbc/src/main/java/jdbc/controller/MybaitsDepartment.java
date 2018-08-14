
package jdbc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import jdbc.mapper.DepartmentMapper;
import jdbc.bean.Department;
/**
 * @author huangyuan
 * @date 2018年6月28日下午1:33:37
 * @Description 测试对部门表的增删改查
 */
@RestController
public class MybaitsDepartment {
	@Autowired
	DepartmentMapper departmentMapper;
	
	@GetMapping("/dept/{id}")
	public Department getDept(@PathVariable("id") Integer id) {
		return departmentMapper.getDeptById(id);
		
	}
	
	@GetMapping("/dept")
	public Department insertDept(Department department) {
		departmentMapper.insertDept(department);
		return department;
	}
}


