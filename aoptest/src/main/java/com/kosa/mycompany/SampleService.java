package com.kosa.mycompany;

public interface SampleService {
	public void displayName();
	public void displayNumber();
	// �߿� : AOP �޼����� ��ȯ���� Object Ÿ���̾�� �Ѵ�
	public Object displayNumber(int limit);
	public void gugudan(int dan);

}
