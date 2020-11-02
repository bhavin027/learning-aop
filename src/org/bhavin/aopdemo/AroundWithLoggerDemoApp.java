package org.bhavin.aopdemo;

import java.util.List;
import java.util.logging.Logger;

//import org.bhavin.aopdemo.dao.AccountDAO;
import org.bhavin.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AroundWithLoggerDemoApp {
	
	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	
	public static void main(String[] args) {
		
		// read the spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("-----------------------------");
		myLogger.info("Main Program: AroundDemoApp");
		myLogger.info("-----------------------------");
		
		myLogger.info("Calling fortune service");
		
		String data = theFortuneService.getFortune();
		
		myLogger.info("\nFortune: "+data);
		
		//close the context
		context.close();
		
	}

}
