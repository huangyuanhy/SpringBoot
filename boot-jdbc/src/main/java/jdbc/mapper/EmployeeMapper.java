/**
 * 
 */
package jdbc.mapper;

import org.apache.ibatis.annotations.Update;

import jdbc.bean.Employee;

/**
 * @author huangyuan
 * @date 2018年6月28日下午5:38:08
 * @Description 使用配置文件方式 配置mapper映射文件
 */
public interface EmployeeMapper {
	public Employee getEmpById(Integer id);
	public void updateEmp(Employee employee);
	public void insertEmp(Employee employee);
}
