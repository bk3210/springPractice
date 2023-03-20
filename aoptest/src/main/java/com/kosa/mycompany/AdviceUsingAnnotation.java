package com.kosa.mycompany;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 자동으로 객체를 만들려면 아래 두 어노테이션이 필요함
// Aspect 설정도 필요하다
@Component
@Aspect
public class AdviceUsingAnnotation {
	@Pointcut("execution(public * com.kosa.mycompany.*ServiceImpl.*(..))")
	private void publicTarget() {
	}
	
	
	// 이렇게 어노테이션 입력하면 xml파일에 썼던 설정이 필요없음
	@Around("publicTarget()")
	public Object aroundTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		// ProceedingJoinPoint : 매개변수 타입
		System.out.println("arround start ******************");

		// 메소드를 중간에서 낚아채는(납치해오는) 객체
		// proceed 메소드를 이용해 본래 메소드를 호출함
		// 얘가 없으면 동작을 못함(메소드 호출을 안하니까)
		String classname = joinPoint.getTarget().getClass().getSimpleName();
		String methodname = joinPoint.getSignature().getName();
		System.out.println("클래스명 : " + classname);
		System.out.println("메소드명 : " + methodname);

		long time1 = System.currentTimeMillis(); // 메소드 시작 시간을 가져옴
		Object retVal = joinPoint.proceed(); // 원래 메소드 호출
		long time2 = System.currentTimeMillis(); // 메소드 종료 시간 가져옴
		System.out.println("실행시간 : " + (time2 - time1) + "밀리초");

		System.out.println("arround end ******************");

		return retVal; // 메소드 반환값을 보낸다
	}
}
