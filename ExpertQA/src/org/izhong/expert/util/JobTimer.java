package org.izhong.expert.util;

import java.util.TimerTask;

import javax.servlet.ServletContext;

import org.izhong.expert.service.AccessLogService;

public class JobTimer extends TimerTask {

	private ServletContext servletContext;
    private static boolean isRunning = false;
    private AccessLogService accessLogService = null;

    public JobTimer(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Override
    public void run() {
        if (!isRunning) {
            isRunning = true;
            servletContext.log("本次任务开始");
            servletContext.log("   ---->" + System.currentTimeMillis());
            
            accessLogService.getAccessLog();
//            new MemberAction().ajxAnalyzeTimer();
//            new MemberAction().ajxAnalyze_3();
//            System.out.println("snake");
//            Random random = new Random();
//            int n = random.nextInt(13);
//            try {
//                Thread.sleep( (n + 1) * 1000);
//            } catch (InterruptedException e) {
//                servletContext.log("系统环境错误");
//            }
            
            isRunning = false;
            servletContext.log("本次任务结束");
        } else {
            servletContext.log("上次任务还在执行");
        }
    }


}
