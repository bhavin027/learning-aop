package org.bhavin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	@Pointcut("execution(* org.bhavin.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("execution(* org.bhavin.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	@Pointcut("execution(* org.bhavin.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAcountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on add*()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiRequest () {
		System.out.println("====>>> API Request @Before advice on add*()");
	}
}
