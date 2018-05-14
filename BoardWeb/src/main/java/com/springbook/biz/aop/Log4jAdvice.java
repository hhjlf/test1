package com.springbook.biz.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class Log4jAdvice {
	@Pointcut("execution(* com.springbook.biz..*.*(..))")
	public void all() {}
	@Before("all()")
	public void printLogging(JoinPoint d) throws Throwable {
		
		String a = d.getSignature().getName();
		Object[] aa = d.getArgs();
		
		System.out.println("사전처리"+a +"Args 메서드:" +aa[0].toString());
	
	
	}
	
	@AfterReturning(pointcut="all()",returning="returnObj")
	public void log(JoinPoint d,Object returnObj) {
		String a = d.getSignature().getName();
		
		if(returnObj == null) {
			System.out.println("사후처리 : " + a +"() 메서드리턴값= null ");
		}else
		System.out.println("사후처리 : " + a +"() 메서드리턴값=" +returnObj.toString() );
		
	}
	@AfterThrowing(pointcut="all()",throwing="exe")
	public void execep(JoinPoint a,Exception exe) {
		String method = a.getSignature().getName();
		System.out.println(method+"() 메서드 실행중 예외발생!");
		
		if(exe instanceof NullPointerException) {
			System.out.println("널포인트익셉션!!!!!!!");
		}else {
			System.out.println("익셉션!!!");
		}
	}
	@After("all()")
		public void aft() {
			System.out.println("이건그냥끝나면무조건나아ㅗ아오아ㅗ아");
		}
	}


