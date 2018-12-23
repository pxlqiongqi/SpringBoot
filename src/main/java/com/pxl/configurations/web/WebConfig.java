package com.pxl.configurations.web;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebMvcAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;  
/**
 * 设置前端包例如jquery等的路径
 * */  
@Configuration  
@EnableWebMvc  
public class WebConfig extends WebMvcAutoConfiguration {  

	public void addResourceHandlers(ResourceHandlerRegistry registry) {  
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");  
	}
	//缓存filter  如果重复数据，返回304
	@Bean
	public ShallowEtagHeaderFilter shallowEtagHeaderFilter() {

		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		ShallowEtagHeaderFilter shallowEtagHeaderFilter=new ShallowEtagHeaderFilter();
		registrationBean.setFilter(shallowEtagHeaderFilter);

		List<String> urls = new ArrayList<>();
		urls.add("/*");
		registrationBean.setUrlPatterns(urls);

		return shallowEtagHeaderFilter;

	}
}  