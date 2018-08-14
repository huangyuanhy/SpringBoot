/**
 * 
 */
package amqp.config;


import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangyuan
 * @date 2018年7月1日下午8:49:15
 * @Description 使用json转化器，这样消息队列中的数据就不是按默认的jdk进行序列化 了
 */
@Configuration
public class JsonConverter {
	
	@Bean
	public MessageConverter myConverter() { 
		return new Jackson2JsonMessageConverter();
	}
	


}
