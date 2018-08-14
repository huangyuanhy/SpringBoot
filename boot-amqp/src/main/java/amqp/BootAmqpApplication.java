package amqp;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableRabbit //开启注解版mq
@SpringBootApplication
public class BootAmqpApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootAmqpApplication.class, args);
	}
}
