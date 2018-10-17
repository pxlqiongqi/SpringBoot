package com.pxl.configurations.mybatis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisCache implements Cache {

	private static RedisTemplate<Object, Object> redisTemplate;

	private final String id;

	private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	public RedisCache(final String id) {
		if (id == null) {
			throw new IllegalArgumentException("Cache instances require an ID");
		}
		this.id = id;
	}

	@Override
	public void clear() {
		redisTemplate.execute((RedisCallback<?>) connection -> {
			connection.flushDb();
			return null;
		});
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public Object getObject(Object key) {
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public ReadWriteLock getReadWriteLock() {
		return this.readWriteLock;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public void putObject(Object key, Object value) {
		redisTemplate.opsForValue().set(key, value);
	}

	@Override
	public Object removeObject(Object key) {
		redisTemplate.delete(key);
		return null;
	}

	public static void setRedisTemplate(RedisTemplate<Object, Object> redisTemplate) {
		RedisCache.redisTemplate=redisTemplate;
	}

}