package 인터페이스;

import java.util.List;

// 인터페이스에는 상수와 메소드 header 부분만 존재함(객체를 생성하지 않기 때문)
public interface IBoardDAO {
	List<BoardDTO> getList();

}
