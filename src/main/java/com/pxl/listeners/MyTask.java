package com.pxl.listeners;
import java.util.Calendar;
import java.util.TimerTask;

// 定时执行的任务类
public class MyTask extends TimerTask {
	private static final int C_SCHEDULE_HOUR = 10;
	private static boolean isRunning = false;
	public void run() {
		Calendar cal = Calendar.getInstance();
		if (!isRunning) {
			if (C_SCHEDULE_HOUR == cal.get(Calendar.HOUR_OF_DAY)) {
				//时间为11点时才执行任务，否则不执行；
				//所以调度器timer.schedule的间隔时间不能大于一小时，否则可能错过时间段；
				//调度器timer.schedule的间隔时间也不能小于一小时，否则可能一天执行几次任务；
				isRunning = true;
				System.out.println("开始执行指定任务");

				// TODO 添加自定义的详细任务，以下只是示例
				int i = 0;
				while (i++ < 5) {
					System.out.println("已完成任务的" + i + "/" + 10);
				}
				//end

				isRunning = false;
				System.out.println("指定任务执行结束");
			} else {
				System.out.println("还不到任务执行的时间");
			}
		} else {
			System.out.println("上一次任务执行还未结束");
		}
	}
}