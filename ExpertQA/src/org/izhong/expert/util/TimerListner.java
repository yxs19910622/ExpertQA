package org.izhong.expert.util;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class TimerListner implements ServletContextListener {

	private Timer timer;
	
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		if (timer != null) {
            timer.cancel();
            arg0.getServletContext().log("定时器已销毁");
        }
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		 timer = new Timer(true);
		 arg0.getServletContext().log("定时器已启动");
		 Calendar calendar = Calendar.getInstance();
		 Date date = new Date();
		 calendar.setTime(date);
		 calendar.add(calendar.DATE,0);//取到明天
		 calendar.set(Calendar.HOUR_OF_DAY, 10); // 控制时
		 calendar.set(Calendar.MINUTE, 55);       // 控制分
		 calendar.set(Calendar.SECOND, 59);       // 控制秒
 
         Date time = calendar.getTime();         // 得出执行任务的时间
        
         timer.schedule(new JobTimer(arg0.getServletContext()), 0, 1000 *10);
         arg0.getServletContext().log("已添加任务");
	}

}
