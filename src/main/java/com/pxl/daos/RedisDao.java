package com.pxl.daos;

import java.util.Date;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;  

/** 
 * redis工具类 
 * 
 * @create 2018-04-24 下午9:41 
 **/
@Repository  
public class RedisDao{  
	@Resource  
	protected RedisTemplate<String,Object> stringRedisTemplate;  

	/** 
	 * 查询key,支持模糊查询 
	 * 
	 * @param key 传过来时key的前后端已经加入了*，或者根据具体处理 
	 * */  
	public Set<String> keys(String key){  
		return stringRedisTemplate.keys(key);  
	}  

	/** 
	 * 重命名key 
	 * */  
	public void renameKey(String key,String newKey){  
		stringRedisTemplate.rename(key,newKey);  
	}  


	/** 
	 *字符串添加信息 
	 * @param key 
	 * @param obj 可以是单个的值，也可以是任意类型的对象 
	 * */  

	public void set(String key,Object obj){  
		stringRedisTemplate.opsForValue().set(key,obj);  
	}  

	/** 
	 *字符串添加信息 
	 * @param key 
	 * @param obj 可以是单个的值，也可以是任意类型的对象 
	 * @param expire 设置失效时间 
	 * */  

	public void set(String key,Object obj,long expire){  
		stringRedisTemplate.opsForValue().set(key,obj,expire,TimeUnit.SECONDS);  
	}  

	/** 
	 * 字符串获取值 
	 * @param key 
	 * */  

	public Object get(String key){  
		return stringRedisTemplate.opsForValue().get(key);  
	}  

	/** 
	 * 删出key 
	 * 这里跟下边deleteKey（）最底层实现都是一样的，应该可以通用 
	 * @param key 
	 * */  

	public void delete(String key){  
		stringRedisTemplate.opsForValue().getOperations().delete(key);  
	}  

	/** 
	 * 添加单个 
	 * 
	 * @param key    key 
	 * @param filed  filed 
	 * @param domain 对象 
	 */  

	public void hset(String key,String filed,Object domain){  
		stringRedisTemplate.opsForHash().put(key, filed, domain);  
	}  


	/** 
	 * 添加HashMap 
	 * 
	 * @param key    key 
	 * @param hm    要存入的hash表 
	 */  

	public void hmset(String key, HashMap<String,Object> hm){  
		stringRedisTemplate.opsForHash().putAll(key,hm);  
	}  

	/** 
	 * 查询key和field所确定的值 
	 * 
	 * @param key 查询的key 
	 * @param field 查询的field 
	 * @return HV 
	 */  

	public Object hget(String key,String field) {  
		return stringRedisTemplate.opsForHash().get(key, field);  
	}  

	/** 
	 * 查询该key下所有值 
	 * 
	 * @param key 查询的key 
	 * @return Map<HK, HV> 
	 */  

	public Object hget(String key) {  
		return stringRedisTemplate.opsForHash().entries(key);  
	}  

	/** 
	 * 删除key下所有值 
	 * 
	 * @param key 查询的key 
	 */  

	public void deleteKey(String key) {  
		stringRedisTemplate.opsForHash().getOperations().delete(key);  
	}  

	/** 
	 * 判断key和field下是否有值 
	 * 
	 * @param key 判断的key 
	 * @param field 判断的field 
	 */  

	public Boolean hasKey(String key,String field) {  
		return stringRedisTemplate.opsForHash().hasKey(key,field);  
	}  

	/** 
	 * 判断key下是否有值 
	 * 
	 * @param key 判断的key 
	 */  

	public Boolean hasKey(String key) {  
		return stringRedisTemplate.opsForHash().getOperations().hasKey(key);  
	}  


	public Boolean expire(String key, long sec) {  
		return stringRedisTemplate.expire(key,sec,TimeUnit.SECONDS);  
	}  


	public Boolean expireAt(String key, Date date) {  
		return stringRedisTemplate.expireAt(key,date);  
	}  
}  
