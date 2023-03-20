package com.kosa.myapp1.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	// Service가 BoardDAO 클래스를 가지고 있음
	// BoardDAO boardDAO=new BoardDAO(); 	이런 식으로 객체 생성하지 않음!! 객체 생성은 Spring이 함
	// @Autowired
	// BoardDAO boardDAO;	// @Autowired는 Spring이 객체를 생성하겠다는 뜻
	
	@Resource(name="boardDAO")	// 최근방식
	BoardDAO boardDAO;			// @Autowired보다 더욱 정밀한 방식으로 제어 가능 
								// = @Repository("이름")에서 지정한 이름을 찾아가서 자기가 생성한 객체에 이름을 부여한다
								// 만약 같은 이름이 나오면 에러를 띄워줌(충돌 방지)

	@Override
	public List<BoardDTO> getList(BoardDTO dto) {
		return boardDAO.getList(dto);
	}

	@Override
	public BoardDTO getView(String seq) {
		return boardDAO.getView(seq);
	}

	@Override
	public void insert(BoardDTO dto) {
		// DAO : table 단위
		// Service : 화면 단위, 여러개의 DAO를 소유할 수 있다
		boardDAO.insert(dto);
	}

	@Override
	public void update(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BoardDTO dto) {
		// TODO Auto-generated method stub
		
	}	

}