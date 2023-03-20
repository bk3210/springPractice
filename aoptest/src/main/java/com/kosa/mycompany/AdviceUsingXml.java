package com.kosa.mycompany;

import org.aspectj.lang.ProceedingJoinPoint;

// Advice Ŭ������ ������� ���� �ʴ� POJO(Plain Old Java Object)
public class AdviceUsingXml {
	public Object aroundTargetMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		// ProceedingJoinPoint : �Ű����� Ÿ��
		System.out.println("arround start");
		
		// �޼ҵ带 �߰����� ����ä��(��ġ�ؿ���) ��ü
		// proceed �޼ҵ带 �̿��� ���� �޼ҵ带 ȣ����
		// �갡 ������ ������ ����(�޼ҵ� ȣ���� ���ϴϱ�)
		String classname = joinPoint.getTarget().getClass().getSimpleName();
		String methodname = joinPoint.getSignature().getName();
		System.out.println("Ŭ������ : " + classname);
		System.out.println("�޼ҵ�� : " + methodname);
		
		long time1 = System.currentTimeMillis();	// �޼ҵ� ���� �ð��� ������
		Object retVal = joinPoint.proceed();	// ���� �޼ҵ� ȣ��
		long time2 = System.currentTimeMillis();	// �޼ҵ� ���� �ð� ������
		System.out.println("����ð� : " + (time2-time1) + "�и���");
				
		System.out.println("arround end");
		
		return retVal;	// �޼ҵ� ��ȯ���� ������
	}

}
