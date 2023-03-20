package com.kosa.myapp1.board;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {
	List<BoardDTO> list = new ArrayList<BoardDTO>(); 

	public BoardDAOImpl() {
		for(int i=1; i<=10; i++) {
			list.add(new BoardDTO(i+"", "제목"+i, "작성자"+i, "내용"+i, "2023-01-27", i+""));
		}
	}

	@Override
	public List<BoardDTO> getList(BoardDTO dto) {
		return list;
	}
	
	@Override
	public void delete(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public BoardDTO getView(String seq) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getSeq().equals(seq)) {	// 선형 검색(모든 값을 둘러보면서 검색하는 방식)
				return list.get(i);
			}
		}
		return new BoardDTO();	// 만일 검색 결과 찾는 값이 없다면 비어있는 객체를 전달
	}
	
	@Override
	public void insert(BoardDTO dto) {
		list.add(dto);
		
		
	}
	
	@Override
	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

}
