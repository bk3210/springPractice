package com.kosa.myapp1.score;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("scoreService")
public class ScoreServiceImpl implements ScoreService {
	
	@Resource(name="scoreDAO")
	ScoreDAO scoreDAO;
	
	@Override
	public List<ScoreDTO> getList(ScoreDTO dto) {
		return scoreDAO.getList(dto);
	}

	@Override
	public ScoreDTO getView(String seq) {
		return scoreDAO.getView(seq);
	}

	@Override
	public void insert(ScoreDTO dto) {
		scoreDAO.insert(dto);
	}

	@Override
	public void update(ScoreDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ScoreDTO dto) {
		// TODO Auto-generated method stub
		
	}

}
