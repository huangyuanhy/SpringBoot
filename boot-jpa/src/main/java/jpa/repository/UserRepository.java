/**
 * 
 */
package jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jpa.entity.User;

/**
 * @author huangyuan
 * @date 2018年6月28日下午7:07:48
 * @Description 编写一个dao 接口 继承jparepository 来操作数据库  具有crud即分页等功能
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
