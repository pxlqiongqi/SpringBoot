package com.pxl.configurations.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

import redis.clients.jedis.JedisPoolConfig;  

@Configuration  
@EnableAutoConfiguration  
public class RedisConfig {  

	private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);  

	@Bean  
	@ConfigurationProperties(prefix="spring.redis")  
	public JedisPoolConfig getRedisConfig(){  
		JedisPoolConfig config = new JedisPoolConfig();
		return config;  
	}  

	@SuppressWarnings("deprecation")
	@Bean  
	@ConfigurationProperties(prefix="spring.redis")  
	public JedisConnectionFactory getConnectionFactory(){  
		JedisConnectionFactory factory = new JedisConnectionFactory();  
		JedisPoolConfig config = getRedisConfig();
		factory.setPoolConfig(config);  
		logger.info("JedisConnectionFactory bean init success.");  
		return factory;  
	}  

	@Bean(name = "stringRedisTemplate")
	public RedisTemplate<?, ?> getStringRedisTemplate(){  
		RedisTemplate<?,?> template = new StringRedisTemplate(getConnectionFactory());  
		return template;  
	}
}