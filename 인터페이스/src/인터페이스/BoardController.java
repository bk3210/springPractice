package �������̽�;

import java.util.List;

public class BoardController {
	IBoardDAO dao = new BoardDAO();
	
	public void output() {
		List<BoardDTO> list = dao.getList();
		for(int i=0; i<list.size(); i++) {
			BoardDTO dto = list.get(i);
			System.out.println(dto.toString());
		}
	}
}
