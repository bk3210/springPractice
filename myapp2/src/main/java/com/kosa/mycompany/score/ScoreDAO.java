package com.kosa.mycompany.score;

import java.util.List;

public interface ScoreDAO {
	List<ScoreDTO> getList(ScoreDTO dto);
	int getTotalCnt(ScoreDTO dto);
	ScoreDTO getView(ScoreDTO dto);
}
