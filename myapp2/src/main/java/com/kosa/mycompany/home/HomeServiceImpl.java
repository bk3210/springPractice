package com.kosa.mycompany.home;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("homeService")
public class HomeServiceImpl implements HomeService{

	@Resource(name="homeDAO")
	HomeDAO homeDAO;
	
	@Override
	public List<HomeDTO> homeList(HomeDTO dto) {
		return homeDAO.homeList(dto);
	}

	@Override
	public void insert(HomeDTO dto) {
		homeDAO.insert(dto);
	}

}
