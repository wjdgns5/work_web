package com.tenco.listeners;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ApplifecycleListener implements ServletContextListener {
// ServletContextListener : 애플리케이션 시작 및 종료 이벤트를 처리합니다.
    public ApplifecycleListener() {
    }
    
    private static final Logger logger =
    		// 소프트웨어의 이벤트를 시스템의 상태 및 동작 정보를 시간 경과에 따라 기록하는 것
    		// ApplifecycleListener : 앱 생명주기
    		Logger.getLogger(ApplifecycleListener.class.getName());
    
    private String timeFormat() {
    	SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
    	return format.format(new Date());
    }
    

    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("--------------");
    	// info : 상태 변경과 같은 정보성 메시지
    	logger.info("웹 애플리케이션 시작됨 >>> " + timeFormat());
    	System.out.println("--------------");
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("--------------------");
    	logger.info("웹 애플리케이션 종료됨 >>> " + System.currentTimeMillis());
    	System.out.println("--------------------");
    }
	
}
