package com.kosa.mycompany.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("testService")
public class TestServiceImpl implements TestService{
	// Service 하나가 여러개의 DAO를 소유할 수 있다(참조해야 할 DB 테이블이 여러개일 경우)
	@Resource(name="testDAO1")
	TestDAO1 testDAO1;
	
	@Resource(name="testDAO2")
	TestDAO2 testDAO2;
	
	@Resource(name="testDAO3")
	TestDAO3 testDAO3;

	@Override
	public void insertData(TestDTO1 dto) {
			testDAO1.insertData(dto);
			testDAO2.insertData(dto);
			// 아래 작업을 실행하면 testDAO3에서 에러를 일으킴
			// 그런데 testDAO3뿐만아니라 testDAO1, testDAO2에도 값이 안 들어감
			// 이 관계를 트랜잭션이라고 부른다
			dto.setTest("123456789101112");
			testDAO3.insertData(dto);
	}
}
