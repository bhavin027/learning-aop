package org.bhavin.aopdemo;

import org.bhavin.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call the business method
		theAccountDAO.addAccount();
		
		// call again
		System.out.println("\nLet's call it again");
		
		//call the business method
		theAccountDAO.addAccount();
		
		//close the context
		context.close();
		
	}

}
