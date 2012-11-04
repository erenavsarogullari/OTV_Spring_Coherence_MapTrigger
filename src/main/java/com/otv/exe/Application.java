package com.otv.exe;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Application class starts the application
 * 
 * @author onlinetechvision.com
 * @since 29 Oct 2012
 * @version 1.0.0
 *
 */
public class Application {

	/**
     * Starts the application
     *
     * @param  String[] args
     *
     */
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		UserCacheUpdater cacheUpdater = (UserCacheUpdater) context.getBean("userCacheUpdater");
		new Thread(cacheUpdater).start();
	}
}
