package org.bhavin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class MyApiRequestAspect {
	
	@Before("org.bhavin.aopdemo.aspect.AOPExpressions.forDaoPackageNoGetterSetter()")
	public void performApiRequest () {
		System.out.println("\n====>>> API Request @Before advice on add*()");
	}
	
}
