package com.kosa.myapp3.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	SqlSessionTemplate sm;

	@Override
	public int getTotalCnt(BoardDTO dto) {
		return sm.selectOne("Board_getTotalCnt", dto);
	}

	@Override
	public List<BoardDTO> getList(BoardDTO dto) {
		return sm.selectList("Board_getList", dto);
	}

	@Override
	public void insert(BoardDTO dto) {
		sm.insert("Board_insert", dto);
	}

	@Override
	public BoardDTO getView(BoardDTO dto) {
		sm.update("Board_upCnt", dto);
		return sm.selectOne("Board_getView", dto);
	}
	
	@Override
	public void reply(BoardDTO dto) {
		sm.insert("Board_reply", dto);
	}
	
	@Override
	public void update_level(BoardDTO dto) {
		sm.update("Board_reply_level_update", dto);
	}
	
	@Override
	public void modify(BoardDTO dto) {
		sm.update("Board_modify", dto);
	}
	
	@Override
	public void delete(BoardDTO dto) {
		//dto = group_id, depth, g_level
		System.out.println("그룹아이디 : " + dto.getGroup_id());
		System.out.println("깊이 : " + dto.getDepth());
		System.out.println("레벨 : " + dto.getG_level());
		int cnt = sm.selectOne("Board_hasChild", dto);
		if(cnt==0) { 	// 글 삭제
			sm.update("Board_delete1", dto);
		}else {	// 자식이 있을 경우 delyn2 필드값만 삭제 표시를 한다
			sm.update("Board_delete2", dto);
		}
	}
}
