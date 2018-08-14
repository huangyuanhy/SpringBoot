/**
 * 
 */
package other.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author huangyuan
 * @date 2018年7月4日下午2:27:05
 * @Description 测试异步任务
 */
@Async
@Service
public class HelloService {
	 public void hello() {
		 try {
			 Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("开启异步任务");
	 }
}
