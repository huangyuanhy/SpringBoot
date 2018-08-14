/**
 * 
 */
package amqp.service;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import amqp.bean.Book;

/**
 * @author huangyuan
 * @date 2018年7月2日下午1:59:30
 * @Description  监听消息队列
 */
@Service
public class BookService {
	@RabbitListener(queues="hy.news")
	public void receive(Book book) {
		System.out.println("收到消息"+book);
	}
	
	@RabbitListener(queues="hy")
	public void receiveMessage(Message message) {
		System.out.println(message.getBody());
		System.out.println(message.getClass());
	}
}
