package �������̽�;

import java.util.ArrayList;
import java.util.List;

public class BoardDAO implements IBoardDAO {
	List<BoardDTO> list = new ArrayList<BoardDTO>();
	
	public BoardDAO() {
		super();
		list.add(new BoardDTO("����1", "�ۼ���1", "����1"));
		list.add(new BoardDTO("����2", "�ۼ���2", "����2"));
		list.add(new BoardDTO("����3", "�ۼ���3", "����3"));
		list.add(new BoardDTO("����4", "�ۼ���4", "����4"));
		list.add(new BoardDTO("����5", "�ۼ���5", "����5"));
		 
		// ���� �����ڰ� ���ٸ� �̰� ��� �ݺ��ؾ� ��
		// BoardDTO dto = new BoardDTO();
		// dto.setTitle("����1");
		// dto.setWriter("�ۼ���1");
		// dto.setContents("����1");
		// list.add(dto);
	}

	@Override
	public List<BoardDTO> getList() {
		return list;
	}	

}
