package com.kosa.mycompany;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// 스프링의 servlet-context.xml 파일을 읽으라고 어노테이션으로 지정해줘야 함(안 그러면 Nullpoint 에러 뜸)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class AOPTest {
	@Autowired
	SampleService service;
	
	@Test	// 라이브러리 import 필요
	public void test(){
		System.out.println("단위 테스트입니다");
		service.displayName();
		service.displayNumber();
		System.out.println(service.displayNumber(1000));
		service.gugudan(5);
	}
}

