package org.bhavin.aopdemo;

import java.util.List;

import org.bhavin.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AfterThrowingDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find accounts
		List<Account> theAccounts = null;
		
		try {
			//add boolean flag to simulate exception
			boolean tripwire = true;
			
			theAccounts=theAccountDAO.findAccounts(tripwire);
		}catch(Exception exc) {
			System.out.println("-----------------------------");
			System.out.println("Main Progam: Caught Exception: "+ exc);
			System.out.println("-----------------------------");
		}
		// display accounts
		System.out.println("-----------------------------");
		System.out.println("Main Progam: AfterThrowingType");
		System.out.println("-----------------------------");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		//close the context
		context.close();
		
	}

}
