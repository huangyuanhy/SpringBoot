package elasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * springboot 默认支持两种技术来和es交互
 * 1 Jest （默认不生效） 需要导入jest工具包
 * 2 springdata elasticsearch
 *    1 client 节点信息clusternodes clusterName
 * 	  2 elasticresearchTemplate 操作cs
 *   3 编写一个elasticsearchREpository 的子接口来操作es
 * @author huangyuan
 * @date 2018年7月3日下午1:38:36
 * @Description
 */
@SpringBootApplication
public class BootElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootElasticsearchApplication.class, args);
	}
}
