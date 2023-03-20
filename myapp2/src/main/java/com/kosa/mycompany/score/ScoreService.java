package com.kosa.mycompany.score;

import java.util.List;

import com.kosa.mycompany.guestbook.GuestbookDTO;

public interface ScoreService {
	List<ScoreDTO> getList(ScoreDTO dto);
	int getTotalCnt(ScoreDTO dto);
	ScoreDTO getView(ScoreDTO dto);

}
