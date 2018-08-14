package jdbc;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import jdbc.bean.Employee;
import jdbc.config.RedisConfig;
import jdbc.mapper.EmployeeMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootJdbcApplicationTests {
	@Autowired
	DataSource dataSource;
	@Autowired
	EmployeeMapper mapper;

	@Test
	public void contextLoads() throws Exception{
		System.out.println(dataSource.getConnection());
		
		//class com.zaxxer.hikari.HikariDataSource 这个是默认的数据源
		System.out.println(dataSource.getClass());
	}

	//注入reids
	@Autowired
	RedisTemplate<Object, Object> redisTemplate; //k v都是对象
	@Autowired
	StringRedisTemplate stringRedis;  //k v 都是字符串的
	
	@Autowired  //使用自己定义的redistemplate
	RedisTemplate<Object, Employee> myRedisTemplate;
	
	//五大类型 set string zset(有序集合) hash list（双端队列） 
	
	@Test
	public void test1() {
		//给String类型添加数据 一下测试都没有问题
		//stringRedis.opsForValue().append("string", "helloword");
		
		//stringRedis.opsForList().leftPush("list", "001");
		//stringRedis.opsForList().leftPush("list", "002");
		
		//下面测试对象保存
		Employee emp = mapper.getEmpById(1);
		//序列化后的保存到redis中 默认采用jdk序列化机制  那边保存的数据看不懂
		redisTemplate.opsForValue().set("emp",emp);
		//以json保存  使用自己的转化方式，详情见redisConfig
		myRedisTemplate.opsForValue().set("emp", emp);
	}	
}















