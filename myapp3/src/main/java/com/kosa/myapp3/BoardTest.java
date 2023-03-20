package com.kosa.myapp3;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.kosa.myapp3.board.BoardDAO;
import com.kosa.myapp3.board.BoardDTO;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
		"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class BoardTest {
	
	@Resource(name="boardDAO")
	BoardDAO dao;
	
    @Test
    public void test() throws Exception {
    	BoardDTO dto = new BoardDTO();
    	System.out.println(dao.getTotalCnt(dto));
    	List<BoardDTO> list = dao.getList(dto);
    	for(int i=0; i<list.size(); i++) {
    		System.out.println(list.get(i).getTitle());
    	}
    }
}
