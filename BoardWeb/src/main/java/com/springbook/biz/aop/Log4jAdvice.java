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
		
		System.out.println("����ó��"+a +"Args �޼���:" +aa[0].toString());
	
	
	}
	
	@AfterReturning(pointcut="all()",returning="returnObj")
	public void log(JoinPoint d,Object returnObj) {
		String a = d.getSignature().getName();
		
		if(returnObj == null) {
			System.out.println("����ó�� : " + a +"() �޼��帮�ϰ�= null ");
		}else
		System.out.println("����ó�� : " + a +"() �޼��帮�ϰ�=" +returnObj.toString() );
		
	}
	@AfterThrowing(pointcut="all()",throwing="exe")
	public void execep(JoinPoint a,Exception exe) {
		String method = a.getSignature().getName();
		System.out.println(method+"() �޼��� ������ ���ܹ߻�!");
		
		if(exe instanceof NullPointerException) {
			System.out.println("������Ʈ�ͼ���!!!!!!!");
		}else {
			System.out.println("�ͼ���!!!");
		}
	}
	@After("all()")
		public void aft() {
			System.out.println("�̰Ǳ׳ɳ����鹫���ǳ��ƤǾƿ��ƤǾ�");
		}
	}


