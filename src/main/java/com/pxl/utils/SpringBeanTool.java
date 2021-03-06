package com.pxl.utils;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


@Component
public class SpringBeanTool implements ApplicationContextAware {

	private static ApplicationContext applicationContext = null;
	public SpringBeanTool() {
		// TODO Auto-generated constructor stub
	}
	private static Logger logger = LoggerFactory.getLogger(SpringBeanTool.class);

	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 */
	public static ApplicationContext getApplicationContext() {
		assertContextInjected();
		return applicationContext;
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	public static <T> T getBean(String name) {
		assertContextInjected();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 从静态变量applicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	public static <T> T getBean(Class<T> requiredType) {
		assertContextInjected();
		return applicationContext.getBean(requiredType);
	}

	/**
	 * 清除SpringContextHolder中的ApplicationContext为Null.
	 */
	public static void clearHolder() {
		logger.debug("清除SpringContextHolder中的ApplicationContext:" + applicationContext);
		applicationContext = null;
	}

	/**
	 * 实现ApplicationContextAware接口, 注入Context到静态变量中.
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		logger.debug("注入ApplicationContext到SpringContextHolder:{}", applicationContext);

		if (SpringBeanTool.applicationContext != null) {
			logger.warn("SpringContextHolder中的ApplicationContext被覆盖, 原有ApplicationContext为:"
					+ SpringBeanTool.applicationContext);
		}
		SpringBeanTool.applicationContext = applicationContext; //NOSONAR
	}


	/**
	 * 检查ApplicationContext不为空.
	 */
	private static void assertContextInjected() {

		Validate.validState(applicationContext != null,"applicaitonContext属性未注入");
	}
}
