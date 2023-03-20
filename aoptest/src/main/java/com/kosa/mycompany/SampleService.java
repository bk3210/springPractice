package com.kosa.mycompany;

public interface SampleService {
	public void displayName();
	public void displayNumber();
	// 중요 : AOP 메서드의 반환값은 Object 타입이어야 한다
	public Object displayNumber(int limit);
	public void gugudan(int dan);

}
