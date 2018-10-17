package com.pxl.listeners;

import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestListener implements ServletContextListener{
	private Timer timer = null;

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		timer = new Timer(true);// true表明定义为守护线程；
		System.out.println("定时器已启动");
		// 定时器调度语句，其中MyTask是自定义需要被调度的执行任务
		// 初始化时就 执行一次任务；
		//此例为每隔六十分钟执行一次任务；
		timer.schedule(new MyTask(), 0, 60 * 60 * 1000);
		System.out.println("已经添加任务调度表");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
		System.out.println("定时器销毁");
	}

}
