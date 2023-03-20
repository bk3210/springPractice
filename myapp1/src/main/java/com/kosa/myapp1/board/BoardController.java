package com.kosa.myapp1.board;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BoardController {
	// @Autowired
	// BoardService service;
	
	@Resource(name="boardService")
	BoardService service;
	
	//	method를 빼면 get/post 두가지 요청을 다 처리하겠다는 뜻
	@RequestMapping(value="/board/list")
	public String getList(BoardDTO dto, Model model) {
		model.addAttribute("list", service.getList(dto));
		return "/board/list";
	}
	
	@RequestMapping(value="/board/write")
	public String write() {
		// 글쓰기창으로 페이지 이동만 처리하는 메소드
		return "/board/write";
	}
	
	@RequestMapping(value="/board/save")
	public String save(BoardDTO dto) {
		service.insert(dto);
		return "redirect:/board/list";	// 등록한 다음 롤백되지 않고 바로 list로 돌아가게 하는 redirect
	}
	
	@RequestMapping(value="/board/view")
	public String view(String seq, Model model) {
		model.addAttribute("dto", service.getView(seq));
		return "/board/view";
	}
}
