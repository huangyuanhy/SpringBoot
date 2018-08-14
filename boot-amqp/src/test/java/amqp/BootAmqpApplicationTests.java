package amqp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Binding.DestinationType;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.context.junit4.SpringRunner;

import amqp.bean.Book;
import net.bytebuddy.implementation.bind.annotation.Argument.BindingMechanic;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootAmqpApplicationTests {
	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	@Autowired
	AmqpAdmin amqpAdmin;//消息管理组件
	
	@Test
	public void amqpTest() {
		/*System.out.println("创建一个exchage");
		amqpAdmin.declareExchange(new DirectExchange("amdin.exchage"));
		System.out.println("创建一个queue");
		amqpAdmin.declareQueue(new Queue("admin.queue"));*/
		//绑定规则
		amqpAdmin.declareBinding(new Binding("admin.queue",DestinationType.QUEUE , "admin.exchage", "admin", null));
	}
	
	
	@Test
	public void contextLoads() {   //发送消息
		//单播点对点测试
		//object 默认当成消息体发送。只需要传入要发送的对象 会自动序列化并发送给rabbitmq
		Map<String ,Object> map=new HashMap<>();
		map.put("msg", "first message");
		map.put("data", Arrays.asList("helloword",true,123));
		//默认采用Java序列化机制
		rabbitTemplate.convertAndSend("exchage-direct", "hy.news", new Book("huangyaun",24));
		
		
	}
	//单播接收消息
	@Test
	public void receive() {
		Object convertSendAndReceive = rabbitTemplate.receiveAndConvert("hy.news");
		System.out.println(convertSendAndReceive.getClass());
		System.out.println(convertSendAndReceive);
	}
	//多播
	@Test
	public void send() {
		rabbitTemplate.convertAndSend("exchage-fanout", "",new Book("guowenjin", 23));
	}

}
