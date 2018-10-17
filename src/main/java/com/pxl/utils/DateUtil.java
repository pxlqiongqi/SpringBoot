package com.pxl.utils;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DateUtil {
	public final static ZoneId zoneId = ZoneId.of("Asia/Shanghai");
	//当前时间
	public static LocalDateTime getNow() {
		return LocalDateTime.now();
	}
	/**
	 * date转LocalDateTime
	 * */
	public static LocalDateTime DateToLocalDateTime(Date date) {
		Instant instant = date.toInstant();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
		return localDateTime;
	}
	/**
	 * LocalDateTime转date
	 * */
	public static Date LocalDateTimeToDate(LocalDateTime localDateTime) {
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
		return date;
	}
	/**
	 * 增减时间
	 * 入参 year month week day hour minute second
	 * */
	public static Date addTime(Date date,String flag,int number) {
		LocalDateTime localDateTime=DateToLocalDateTime(date);
		if("year".equals(flag)) {
			localDateTime=localDateTime.plusYears(number);
		}
		if("month".equals(flag)) {
			localDateTime=localDateTime.plusMonths(number);
		}
		if("week".equals(flag)) {
			localDateTime=localDateTime.plusWeeks(number);
		}
		if("day".equals(flag)) {
			localDateTime=localDateTime.plusDays(number);
		}
		if("hour".equals(flag)) {
			localDateTime=localDateTime.plusHours(number);	
		}
		if("minute".equals(flag)) {
			localDateTime=localDateTime.plusMinutes(number);
		}
		if("second".equals(flag)) {
			localDateTime=localDateTime.plusSeconds(number);
		}
		return LocalDateTimeToDate(localDateTime);
	}
	/**
	 * 增减时间
	 * map.put("day", 1);
	 * map.put("year", 1);
	 * */
	public static Date addTime(Date date,Map<String,Integer> map) {
		for(Map.Entry<String,Integer> entry:map.entrySet()) {
			date=addTime(date,entry.getKey(),entry.getValue());
		}
		return date;
	}
	public static void main(String[] args) {
		Map<String,Integer> map=new HashMap<String,Integer>();
		map.put("day", -1);
		map.put("year", -1);
		System.out.println(addTime(new Date(),map));
	}
}
