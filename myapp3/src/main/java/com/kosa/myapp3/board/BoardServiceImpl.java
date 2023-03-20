package com.kosa.myapp3.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Resource(name = "boardDAO")
	BoardDAO boardDAO;

	@Override
	public int getTotalCnt(BoardDTO dto) {
		return boardDAO.getTotalCnt(dto);
	}

	@Override
	public List<BoardDTO> getList(BoardDTO dto) {
		return boardDAO.getList(dto);
	}

	@Override
	public void insert(BoardDTO dto) {
		boardDAO.insert(dto);
	}
	
	@Override
	public BoardDTO getView(BoardDTO dto) {
		return boardDAO.getView(dto);
	}
	
	@Override
	public void reply(BoardDTO dto) {
		// 이 dto의 seq: 부모글의 seq
		// 부모글의 정보를 가져와야 한다
		BoardDTO parentDTO = boardDAO.getView(dto);
		dto.setGroup_id(parentDTO.getGroup_id());
		dto.setDepth(parentDTO.getDepth()+1);
		dto.setG_level(parentDTO.getG_level()+1);
		// 부모글 기준으로 update_level
		boardDAO.update_level(parentDTO);	// 변경된 부모글의 정보
		boardDAO.reply(dto);	// 빈자리에 새로 추가되어 올라가는 자식글의 정보
	}
	
	@Override
	public void modify(BoardDTO dto) {
		BoardDTO presentDTO = boardDAO.getView(dto);
		dto.setTitle(presentDTO.getTitle());
		dto.setContents(presentDTO.getContents());
		boardDAO.modify(dto);
	}
	
	@Override
	public void delete(BoardDTO dto) {
		boardDAO.delete(dto);
	}

}
