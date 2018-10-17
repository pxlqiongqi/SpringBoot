package com.pxl.configurations.web;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
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
}  