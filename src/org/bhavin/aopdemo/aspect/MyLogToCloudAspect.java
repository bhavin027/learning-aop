package org.bhavin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLogToCloudAspect {

	@Before("org.bhavin.aopdemo.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void logToCloud () {
		System.out.println("\n====>>> Cloud logging @Before advice on add*()");
	}
	
}
