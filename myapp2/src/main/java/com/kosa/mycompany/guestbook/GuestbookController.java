package com.kosa.mycompany.guestbook;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GuestbookController {
	@Resource(name="guestbookService")
	GuestbookService service;
	
	@RequestMapping(value="/guestbook/list")
	public String getList(GuestbookDTO dto, Model model) {
		List<GuestbookDTO> list = service.getList(dto);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getTitle());
		}
		model.addAttribute("list", list);
		model.addAttribute("totalCnt", service.getTotalCnt(dto));
		return "guestbook/list";
	}
	
	@RequestMapping(value="/guestbook/view")
	public String getView(GuestbookDTO dto, Model model) {
		GuestbookDTO resultDTO = service.getView(dto);
		model.addAttribute("dto", resultDTO);
		return "guestbook/view";
	}
	
	@RequestMapping(value="/guestbook/write")
	public String write(Model model) {
		return "guestbook/write";	// 페이지 이동만
	}
	
	@RequestMapping(value="/guestbook/save")
	public String save(GuestbookDTO dto, Model model) {
		// service를 이용해 db에 등록
		service.insert(dto);
		return "redirect:/guestbook/list";
		// redirect를 하는 이유 : request 객체의 내용을 지우고 직접 jsp로 이동하는 게 아니라
		// guestbook/list url로 이동시에 redirect를 해야함
		
		// 등록을 하고 나면 getList() 메소드를 호출해야 하는데 직접 할 수 없음,
		// 프레임워크가 하는 것
		// 메소드를 직접 호출할 수 없으니 url로 접근해야 함
		// redirect : 호출할 url
	}
}
