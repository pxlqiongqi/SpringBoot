package com.pxl.utils;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {
	public static String randomString(int length){
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<length;i++) {
			//产生A-Z的ASCII码
			char randomChar=(char)Math.round(Math.random()*25+65); 
			//产生a-z的ASCII码
			//char randomChar=(char)Math.round(Math.random()*25+97);
			sb.append(String.valueOf((randomChar)));
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		System.out.println(randomString(6));
	}
}
