package com.kosa.mycompany.score;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	
	@Resource(name="scoreDAO")
	ScoreDAO dao;

	@Override
	public List<ScoreDTO> getList(ScoreDTO dto) {
		return dao.getList(dto);
	}

	@Override
	public int getTotalCnt(ScoreDTO dto) {
		return dao.getTotalCnt(dto);
	}
	
	@Override
	public ScoreDTO getView(ScoreDTO dto) {
		return dao.getView(dto);
	}
	  
}
