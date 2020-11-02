package org.bhavin.aopdemo;

import java.util.List;

import org.bhavin.aopdemo.dao.AccountDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		//call method to find accounts
		List<Account> theAccounts = theAccountDAO.findAccounts();
		
		// display accounts
		System.out.println("-----------------------------");
		System.out.println("Main Progam: AfterReturnType");
		System.out.println("-----------------------------");
		System.out.println(theAccounts);
		System.out.println("\n");
		
		//close the context
		context.close();
		
	}

}
