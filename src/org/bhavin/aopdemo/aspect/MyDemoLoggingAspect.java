package org.bhavin.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.bhavin.aopdemo.Account;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Before("org.bhavin.aopdemo.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAcountAdvice(JoinPoint theJoinPoint) {
		myLogger.info("\n====>>> Executing @Before advice");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: "+methodSig);
		
		// display method arguements
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru args
		for(Object tempArgs: args) {
			myLogger.info(tempArgs.toString());
			
			if(tempArgs instanceof Account) {
				Account theAccount = (Account) tempArgs;
				
				myLogger.info("Account name: "+ theAccount.getName());
				myLogger.info("Account level: "+ theAccount.getLevel());
			}
		}
		
	}
	
	// add a new advice for @AfterReturning on find accounts method;
	@AfterReturning(
			pointcut = "execution(* org.bhavin.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning ="result"
			)
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>>Executing @AfterReturning on method: "+method);
		
		//print out the results of method call
		myLogger.info("Result: "+ result);
		
		// post-process the data (modify data)
		if(!(result.isEmpty())) {
			Account temp = result.get(2);
			temp.setName("Degea");
		}
		
		convertAccountNameToUpperCase(result);
	}

	private void convertAccountNameToUpperCase(List<Account> result) {
		
		for(Account temp : result) {
			String theUpperName = temp.getName().toUpperCase();
			temp.setName(theUpperName);
		}
	}
	
	@AfterThrowing(
			pointcut = "execution(* org.bhavin.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing ="theExc"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		//print method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>>Executing @AfterThrowing on method: "+method);
		//log the exception
		myLogger.info("Exception: "+theExc);
	}
	
	@After("execution(* org.bhavin.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint theJoinPoint) {
		//print method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>>Executing @After(finally) on method: "+method);
		
	}
	
	@Around("execution(* org.bhavin.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(
			ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
		
		//print method we are advising on
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n====>>>Executing @Around on method: "+method);
		
		// get begin timestamp
		long beginTime = System.currentTimeMillis();
		
		//execute the method
		Object result = theProceedingJoinPoint.proceed();
		
		//get end timestamp
		long endTime = System.currentTimeMillis();
		
		//compute duration and display it
		long durationTask = endTime - beginTime;
		myLogger.info("\n====>>> Time taken: "+durationTask/1000.0+" Seconds");
		
		return result;
	}
	
}
