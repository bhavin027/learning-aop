package org.bhavin.aopdemo;

import java.util.List;

//import org.bhavin.aopdemo.dao.AccountDAO;
import org.bhavin.aopdemo.service.TrafficFortuneService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AroundDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("-----------------------------");
		System.out.println("Main Program: AroundDemoApp");
		System.out.println("-----------------------------");
		
		System.out.println("Calling fortune service");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\nFortune: "+data);
		
		//close the context
		context.close();
		
	}

}
