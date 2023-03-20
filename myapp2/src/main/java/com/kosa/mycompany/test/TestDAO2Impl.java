package com.kosa.mycompany.test;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("testDAO2")
public class TestDAO2Impl implements TestDAO2 {

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public void insertData(TestDTO1 dto) {
		sm.insert("test2_insert", dto);
	}

}
