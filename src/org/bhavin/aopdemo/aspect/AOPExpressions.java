package org.bhavin.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AOPExpressions {
	
	@Pointcut("execution(* org.bhavin.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("execution(* org.bhavin.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* org.bhavin.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
