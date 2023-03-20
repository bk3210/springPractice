package com.kosa.mycompany;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// �ڵ����� ��ü�� ������� �Ʒ� �� ������̼��� �ʿ���
// Aspect ������ �ʿ��ϴ�
@Component
@Aspect
public class AdviceUsingAnnotation {
	@Pointcut("execution(public * com.kosa.mycompany.*ServiceImpl.*(..))")
	private void publicTarget() {
	}
	
	
	// �̷��� ������̼� �Է��ϸ� xml���Ͽ� ��� ������ �ʿ����
	@Around("publicTarget()")
	public Object aroundTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		// ProceedingJoinPoint : �Ű����� Ÿ��
		System.out.println("arround start ******************");

		// �޼ҵ带 �߰����� ����ä��(��ġ�ؿ���) ��ü
		// proceed �޼ҵ带 �̿��� ���� �޼ҵ带 ȣ����
		// �갡 ������ ������ ����(�޼ҵ� ȣ���� ���ϴϱ�)
		String classname = joinPoint.getTarget().getClass().getSimpleName();
		String methodname = joinPoint.getSignature().getName();
		System.out.println("Ŭ������ : " + classname);
		System.out.println("�޼ҵ�� : " + methodname);

		long time1 = System.currentTimeMillis(); // �޼ҵ� ���� �ð��� ������
		Object retVal = joinPoint.proceed(); // ���� �޼ҵ� ȣ��
		long time2 = System.currentTimeMillis(); // �޼ҵ� ���� �ð� ������
		System.out.println("����ð� : " + (time2 - time1) + "�и���");

		System.out.println("arround end ******************");

		return retVal; // �޼ҵ� ��ȯ���� ������
	}
}
