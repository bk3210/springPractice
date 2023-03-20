package com.kosa.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	
	@RequestMapping(value="/userinfo", method=RequestMethod.POST)
	public String add(Model model, UserDTO dto) {
		/*model.addAttribute("user_id", dto.getUser_id());
		model.addAttribute("user_name", dto.getUser_name());
		model.addAttribute("password", dto.getPassword());
		model.addAttribute("phone", dto.getPhone());
		model.addAttribute("address", dto.getAddress());*/
		
		model.addAttribute("dto", dto);
		return "userinfo";
	}

}
