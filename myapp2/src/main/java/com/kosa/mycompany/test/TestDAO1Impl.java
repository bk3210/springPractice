package com.kosa.mycompany.test;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("testDAO1")
public class TestDAO1Impl implements TestDAO1 {

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public void insertData(TestDTO1 dto) {
		sm.insert("test1_insert", dto);
	}

}
