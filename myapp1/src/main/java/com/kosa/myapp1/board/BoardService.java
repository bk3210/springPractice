package com.kosa.myapp1.board;

import java.util.List;


public interface BoardService {
	List<BoardDTO> getList(BoardDTO dto);

	BoardDTO getView(String seq);

	void insert(BoardDTO dto);

	void update(BoardDTO dto);

	void delete(BoardDTO dto);
}
