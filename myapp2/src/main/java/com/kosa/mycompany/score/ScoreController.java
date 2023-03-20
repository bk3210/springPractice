package com.kosa.mycompany.score;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ScoreController {
	@Resource(name="scoreService")
	ScoreService service;
	
	@RequestMapping(value="/score/list")
	public String getList(ScoreDTO dto, Model model) {
		List<ScoreDTO> list = service.getList(dto);
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName());
		}
		model.addAttribute("list", list);
		model.addAttribute("totalCnt", service.getTotalCnt(dto));
		return "score/list";
	}
}
