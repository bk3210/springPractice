package com.kosa.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {
	// url : http://127.0.0.1:9000/test(�� ����ǵ��� web.xml�� �����ص׾���(/��� �¿쿡 ��� ���� ���� �̸� mapping�� �ξ���)
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String test() {
		System.out.println("�׽�Ʈ�Դϴ�");
		return "test";
	}
	
	// �Ķ���� �����ϱ�
	// url : http://127.0.0.1:9000/myapp/test2?user_id=test1&password=1234
	@RequestMapping(value="/test2", method=RequestMethod.GET)
	public String test2(String user_id, String password, Model model, TestDTO dto) {
		
		// model�� request ��ü ��� jsp�� ���� ������ �������� ����
		model.addAttribute("user_id", user_id);
		model.addAttribute("password", password);
		
		System.out.println("user_id : " + user_id);
		System.out.println("password : " + password);

		System.out.println("user_id : " + dto.getUser_id());
		System.out.println("password : " + dto.getPassword());
		// ��, �������� �Ȱ��� �� ������ dto�ε�, �Ķ���ͷε� �� ������ ������
		
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
	// ����� url ǥ���� ������ �������� �ٲ��� �߼�
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
