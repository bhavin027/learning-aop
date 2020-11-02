package org.bhavin.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	@Before("org.bhavin.aopdemo.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAcountAdvice(JoinPoint theJoinPoint) {
		System.out.println("\n====>>> Executing @Before advice");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: "+methodSig);
		
		// display method arguements
		// get args
		Object[] args = theJoinPoint.getArgs();
		
		//loop thru args
		for(Object tempArgs: args) {
			System.out.println(tempArgs);
			
			if(tempArgs instanceof Account) {
				Account theAccount = (Account) tempArgs;
				
				System.out.println("Account name: "+ theAccount.getName());
				System.out.println("Account level: "+ theAccount.getLevel());
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
		System.out.println("\n====>>>Executing @AfterReturning on method: "+method);
		
		//print out the results of method call
		System.out.println("Result: "+ result);
		
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
	
}
