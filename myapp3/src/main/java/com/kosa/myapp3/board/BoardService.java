package com.kosa.myapp3.board;

import java.util.List;

public interface BoardService {
	int getTotalCnt(BoardDTO dto);
	List<BoardDTO> getList(BoardDTO dto);
	void insert(BoardDTO dto);
	BoardDTO getView(BoardDTO dto);
	void reply(BoardDTO dto);
	void modify(BoardDTO dto);
	void delete(BoardDTO dto);

}
