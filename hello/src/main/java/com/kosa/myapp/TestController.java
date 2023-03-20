package com.kosa.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	// url : http://127.0.0.1:9000/test(로 연결되도록 web.xml에 지정해뒀었음(/경로 좌우에 어느 값이 들어갈지 미리 mapping해 두었음)
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {
		System.out.println("테스트입니다");
		return "test";
	}
	
	// 파라미터 전달하기
	// url : http://127.0.0.1:9000/myapp/test2?user_id=test1&password=1234
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public String test2(String user_id, String password, Model model, TestDTO dto) {
		
		// model은 request 객체 대신 jsp로 값을 전달할 목적으로 사용됨
		model.addAttribute("user_id", user_id);
		model.addAttribute("password", password);
		
		System.out.println("user_id : " + user_id);
		System.out.println("password : " + password);

		System.out.println("user_id : " + dto.getUser_id());
		System.out.println("password : " + dto.getPassword());
		// 즉, 변수명이 똑같은 게 있으면 dto로도, 파라미터로도 값 전달이 가능함
		
		return "test2";
	}
	
	// url : http://127.0.0.1:9000/myapp/add?x=5&y=6
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public String add(HttpServletRequest req, Model model) {
		int x = Integer.parseInt(req.getParameter("x"));
		int y = Integer.parseInt(req.getParameter("y"));
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("result", x+y);
		
		return "add";
	}
	
	// url : http://127.0.0.1:9000/myapp/sub/5/6
	// 현재는 url 표준이 위보다 이쪽으로 바뀌어가는 추세
	@RequestMapping(value="/sub/{x}/{y}", method=RequestMethod.GET)
	public String sub(Model model, @PathVariable("x")int x, @PathVariable("y")int y) {
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		
		model.addAttribute("x", x);
		model.addAttribute("y", y);
		model.addAttribute("result", x-y);
		
		return "sub";
	}
	
	
}
