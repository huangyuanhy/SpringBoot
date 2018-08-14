/**
 * 
 */
package jdbc.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jdbc.bean.Department;

/**
 * @author huangyuan
 * @date 2018年6月28日下午1:21:32
 * @Description 注解版mapper
 */
//@org.apache.ibatis.annotations.Mapper  在启动类上已经配置了批量扫描
public interface DepartmentMapper {
	
	@Select("select * from department where id=#{id}")
	public Department getDeptById(Integer id);
	
	@Delete("delete from department where id=#{id}")
	public int deleteDeptById(Integer id);
	
	@Options(useGeneratedKeys=true,keyProperty="id")//id 将会封装在department中
	@Insert("insert into department(departmentName) values (#{departmentName})")
	public int insertDept(Department department);
	
	@Update("update department set departmentName=#{departmentName} where id=#{id} ")
	public int updateDept(Department department);
}














