package other;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
/**
 * 
 * @author huangyuan
 * @date 2018年7月4日下午2:25:31
 * @Description 测试异步任务  定时任务 邮件任务
 */
@EnableAsync   //开启异步功能
@SpringBootApplication
public class BootOtherApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootOtherApplication.class, args);
	}
}
