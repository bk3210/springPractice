package com.kosa.mycompany;

import org.aspectj.lang.ProceedingJoinPoint;

// Advice 클래스는 상속조차 받지 않는 POJO(Plain Old Java Object)
public class AdviceUsingXml {
	public Object aroundTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		// ProceedingJoinPoint : 매개변수 타입
		System.out.println("arround start");
		
		// 메소드를 중간에서 낚아채는(납치해오는) 객체
		// proceed 메소드를 이용해 본래 메소드를 호출함
		// 얘가 없으면 동작을 못함(메소드 호출을 안하니까)
		String classname = joinPoint.getTarget().getClass().getSimpleName();
		String methodname = joinPoint.getSignature().getName();
		System.out.println("클래스명 : " + classname);
		System.out.println("메소드명 : " + methodname);
		
		long time1 = System.currentTimeMillis();	// 메소드 시작 시간을 가져옴
		Object retVal = joinPoint.proceed();	// 원래 메소드 호출
		long time2 = System.currentTimeMillis();	// 메소드 종료 시간 가져옴
		System.out.println("실행시간 : " + (time2-time1) + "밀리초");
				
		System.out.println("arround end");
		
		return retVal;	// 메소드 반환값을 보낸다
	}

}
