package com.kosa.myapp1.score;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScoreController {
	@Resource(name="scoreService")
	ScoreService service;
	
	@RequestMapping(value="/score/list")
	public String getList(ScoreDTO dto, Model model) {
		model.addAttribute("list", service.getList(dto));
		return "/score/list";
	}

	@RequestMapping(value="/score/write")
	public String write() {
		return "/score/write";
	}
	
	@RequestMapping(value="/score/save")
	public String save(ScoreDTO dto) {
		service.insert(dto);
		return "redirect:/score/list";		// sendRedirect
	}
	
	@RequestMapping(value="/score/view")
	public String view(String seq, Model model) {
		model.addAttribute("dto", service.getView(seq));
		return "/score/view";
	}

}
