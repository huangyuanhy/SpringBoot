/**
 * 
 */
package jdbc.config;


import java.net.UnknownHostException;
import java.util.LinkedHashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.redis.cache.*;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import jdbc.bean.Employee;

/**
 * @author huangyuan
 * @date 2018年6月30日下午7:22:06
 * @Description 定制redis序列化器  默认采用jdk的序列化机制
 */
@Configuration
public class RedisConfig {
	
	@Bean
	public RedisTemplate<Object, Employee> myRedisTemplate(RedisConnectionFactory redisConnectionFactory) throws UnknownHostException{
		RedisTemplate<Object, Employee> template=new RedisTemplate<>();
		template.setConnectionFactory(redisConnectionFactory);
		Jackson2JsonRedisSerializer<Employee> serializer=new Jackson2JsonRedisSerializer<>(Employee.class);
		template.setDefaultSerializer(serializer);
		
			
		return template;
	}
	//Redis配置cacheManager 使用自己序列化的redisTemplates  这样才保存的json 否则使用jdk的序列化机制
	/*@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		new RedisCacheManager(new DefaultRedisCacheWriter(redisConnectionFactory),
				RedisCacheConfiguration.defaultCacheConfig());
		return null;*/
		/*RedisCacheManagerBuilder builder = RedisCacheManager
				.builder(redisConnectionFactory)
				.cacheDefaults(determineConfiguration(resourceLoader.getClassLoader()));
		List<String> cacheNames = this.cacheProperties.getCacheNames();
		if (!cacheNames.isEmpty()) {
			builder.initialCacheNames(new LinkedHashSet<>(cacheNames));
		}
		return this.customizerInvoker.customize(builder.build());*/
	/*@Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(redisConnectionFactory);

        // 使用Jackson2JsonRedisSerialize 替换默认序列化
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper objectMapper = new ObjectMapper();
        //objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);

        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);

        // 设置value的序列化规则和 key的序列化规则
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }*/
}
















