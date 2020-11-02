package org.bhavin.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
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
		System.out.println("\n====>>> Executing @Before advice on add*()");
		
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
	
}
