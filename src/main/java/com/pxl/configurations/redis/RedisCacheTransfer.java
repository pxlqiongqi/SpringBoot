package com.pxl.configurations.redis;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.pxl.configurations.mybatis.RedisCache;

@Component
public class RedisCacheTransfer {

	@Resource
	public void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
		RedisCache.setRedisTemplate(redisTemplate);
	}

}