package com.kosa.myapp1.score;

import java.util.List;

public interface ScoreService {
	List<ScoreDTO> getList(ScoreDTO dto);
	ScoreDTO getView(String seq);
	void insert(ScoreDTO dto);
	void update(ScoreDTO dto);
	void delete(ScoreDTO dto);

}
