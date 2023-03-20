package com.kosa.mycompany.test;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("testDAO3")
public class TestDAO3Impl implements TestDAO3 {

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public void insertData(TestDTO1 dto) {
		sm.insert("test3_insert", dto);
	}

}
