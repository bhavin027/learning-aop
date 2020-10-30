package org.bhavin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	// add all of our related advices for logging
	
	// start with an @Before advice
	
	@Before("execution(public void org.bhavin.aopdemo.dao.AccountDAO.addAccount())")
	public void beforeAddAcountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on addAccount()");
	}
	
}
