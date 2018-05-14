package com.springbook.biz.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("비포 어라운드 ");
		Object re = pjp.proceed();
		System.out.println("에프터 어라운드");
		return re;
	}

}
