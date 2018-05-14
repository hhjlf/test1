package com.springbook.biz.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class AroundAdvice {
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("���� ����� ");
		Object re = pjp.proceed();
		System.out.println("������ �����");
		return re;
	}

}
