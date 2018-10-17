package com.pxl.utils;


import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class JsonToPojoToMap {
	public static Logger log=LoggerFactory.getLogger(JsonToPojoToMap.class);
	/**
	 * JSON转POJO
	 * */
	public static Object JsonToPojo(JSONObject jSONObject,Class<?> clazz){
		return jSONObject.toJavaObject(clazz);
	}
	/**
	 * POJO转JSON
	 * */
	public static JSONObject PojoToJson(Object object){
		JSONObject json=(JSONObject) JSONObject.toJSON(object);
		return json;
	}
	/**
	 * Map转POJO
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws InvocationTargetException 
	 * */
	public static Object MapToPojo(Map map,Class<?> clazz) throws InstantiationException, IllegalAccessException, InvocationTargetException{
		if (map == null) {
			return null;  
		}
		Object obj = clazz.newInstance();  
		BeanUtils.populate(obj, map);  
		return obj;  
	}
	/**
	 * POJO转Map
	 * */
	public static Map PojoToMap(Object object){
		Map map = new HashMap();  
	    if (object != null) {  
	    	BeanMap beanMap =new BeanMap(object);
	        for(Object key:beanMap.keySet()){
	            map.put(key, beanMap.get(key));  
	        }             
	    }
		return map;
	}
	/**
	 * JSON转Map
	 * */
	public static Map JsonToMap(JSONObject json){
		Map map=(Map)json;
		return map;
	}
	/**
	 * Map转JSON
	 * */
	public static JSONObject MapToJson(Map map){
		JSONObject json=new JSONObject(map);
		return json;
	}
	/**
	 * String转JSON
	 * */
	public static JSONObject StringToJson(String str){
		JSONObject json=new JSONObject();
		try {
			json=JSONObject.parseObject(str);
		}catch(Exception e){
			log.debug("str转换JSON false");
		}
		return json;
	}
	public static void main(String[] args){
		System.out.println(StringToJson("1111111111"));
	}
}
