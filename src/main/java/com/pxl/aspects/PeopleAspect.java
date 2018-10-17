package com.pxl.aspects;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
@Component
@Aspect
public class PeopleAspect {
	@Pointcut("execution(* com.pxl.services.PeopleService.*(..))")
	private void PeoplePoint() {
	}
	@Before("PeoplePoint()")
	public void before() {
		//System.out.println("before");
	}
	@AfterReturning(pointcut="PeoplePoint()",returning="object")
	public void after(JoinPoint jp,Object object) {
		//System.out.println(object);
	}
	/*@Around("PeoplePoint()")
	public Object around(ProceedingJoinPoint pj) throws Throwable {
		Signature signature = pj.getSignature();    
		MethodSignature methodSignature = (MethodSignature)signature;    
		Method targetMethod = methodSignature.getMethod();    
		System.out.println("method:" + targetMethod.getName());
		System.out.println(targetMethod.getDeclaringClass().getName()+"  "+pj.getSignature().getName()+"开始执行");
		Object obj=pj.proceed();
		System.out.println("执行结束");
		return obj;
	}*/

}
