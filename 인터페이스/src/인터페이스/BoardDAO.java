package 인터페이스;

import java.util.ArrayList;
import java.util.List;

public class BoardDAO implements IBoardDAO {
	List<BoardDTO> list = new ArrayList<BoardDTO>();
	
	public BoardDAO() {
		super();
		list.add(new BoardDTO("제목1", "작성자1", "내용1"));
		list.add(new BoardDTO("제목2", "작성자2", "내용2"));
		list.add(new BoardDTO("제목3", "작성자3", "내용3"));
		list.add(new BoardDTO("제목4", "작성자4", "내용4"));
		list.add(new BoardDTO("제목5", "작성자5", "내용5"));
		 
		// 만약 생성자가 없다면 이걸 계속 반복해야 함
		// BoardDTO dto = new BoardDTO();
		// dto.setTitle("제목1");
		// dto.setWriter("작성자1");
		// dto.setContents("내용1");
		// list.add(dto);
	}

	@Override
	public List<BoardDTO> getList() {
		return list;
	}	

}
