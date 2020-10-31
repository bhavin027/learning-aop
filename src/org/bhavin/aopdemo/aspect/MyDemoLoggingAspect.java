package org.bhavin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(3)
public class MyDemoLoggingAspect {
	
	@Before("org.bhavin.aopdemo.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void beforeAddAcountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on add*()");
	}
	
}
