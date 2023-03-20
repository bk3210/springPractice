package com.kosa.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BoardController {
	// 항상 RequestMapping의 value값(url)이 중복되면 안된다
	// POST 방식으로 보내기
	@RequestMapping(value="/post/add", method=RequestMethod.POST)
	public String add(int x, int y, Model model){
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("result", x+y);
		
		return "post/add";
	}

}
