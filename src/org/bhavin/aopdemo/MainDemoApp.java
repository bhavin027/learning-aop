package org.bhavin.aopdemo;

import org.bhavin.aopdemo.dao.AccountDAO;
import org.bhavin.aopdemo.dao.MembershipDAO;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read the spring config java class
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the business method
		Account myAccount = new Account();
		myAccount.setName("Jane Dao");
		myAccount.setLevel("Level 5");
		theAccountDAO.addAccount(myAccount, true);
		theAccountDAO.doWork();
		
		// call account getter/setters
		theAccountDAO.setName("booo");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		//call the business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.gotToSleep();
		
		//close the context
		context.close();
		
	}

}
