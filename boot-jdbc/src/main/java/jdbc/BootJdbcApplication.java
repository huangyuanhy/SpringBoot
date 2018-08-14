package jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(value="jdbc.mapper") //批量扫描mapper
@SpringBootApplication
@EnableCaching //开启缓存 
public class BootJdbcApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootJdbcApplication.class, args);
	}
}
