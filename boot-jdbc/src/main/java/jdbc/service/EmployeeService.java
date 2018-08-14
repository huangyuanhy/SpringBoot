/**
 * 
 */
package jdbc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import jdbc.bean.Employee;
import jdbc.mapper.EmployeeMapper;

/**
 * @author huangyuan
 * @date 2018年6月29日下午1:44:45
 * @Description
 */
@Service
public class EmployeeService {
	@Autowired
	EmployeeMapper employeeMapper;
	
	//将此查询结果缓存起来，以后再次执行就不用查数据库了
	  //cacheNames 缓存组件的名字 多个名字，key 缓存的key默认是参数值 支持spel表达式
	//keyGenerator/key 二选一     cacheManager/cacheResolver 指定从哪个管理器获取 #id  #root.args[0].name
	//conditon 指定条件才缓存    condition="#id>1"
	//sync 是否启用异步模式  默认采用同步
	//unless 指定条件为true  不缓存   unless="#result==null"
	@Cacheable(cacheNames="emp", key="#id")
	public Employee getEmp(Integer id) {
		System.out.println("查询"+id +"号员工");
		Employee employee=employeeMapper.getEmpById(id);
		return employee;
	}
	
	//@cacheput 先调用方法，又更新缓存 常用于update方法   此时一定要指定 更新哪个key 否则不会覆盖 之前的缓存    
		@CachePut(cacheNames="emp",key="#result.id")
	public Employee updateEmp(Employee e) {
			System.out.println("更新员工");
			employeeMapper.updateEmp(e);
		return e;
	}
		
		@CacheEvict(value="emp",key="#id") //删除缓存  allEntries=false.此属性是否删除所有的缓存key
		public void delete(Integer id ) {
			System.out.println("删除成功");
		}
	
}
