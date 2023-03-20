package com.kosa.mycompany.home;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("homeDAO")
public class HomeDAOImpl implements HomeDAO {
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<HomeDTO> homeList(HomeDTO dto) {
		return sm.selectList("Home_getList", dto);
	}

	@Override
	public void insert(HomeDTO dto) {
		sm.insert("Home_insert", dto);	
	}
	

}
