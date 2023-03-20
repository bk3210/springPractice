package com.kosa.mycompany.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping(value="/member/write")
	public String write() {
		return "/member/member_write";
	}
		
	@RequestMapping(value="/member/save")
	public String save(MemberDTO dto) {
		
		System.out.println("************************************* " + dto.getM_userid());
		service.insert(dto);
		return "redirect:/";		// home으로 이동
	}
	
	@ResponseBody	// jsp 이동이 아니라 json 형태의 데이터를 출력함
	@RequestMapping(value="/member/idcheck")
	public Map<String, String> idcheck(MemberDTO dto) {
		// return "페이지명";을 쓰면 viewResolver가 가져가서 JSP를 호출하도록 되어있다
		// 그런데 idcheck 메소드는 JSON형태로 데이터를 보내서 Ajax로 처리하려고 하기 때문에 return 결과로 JSP 호출을 하면 안된다
		// 그래서 JSP로 가지 말라고 @ResponseBody 어노테이션을 쓴다
		Map<String, String> map = new HashMap<String, String>();	// 자바 객체를 JSON 객체로 내보낼 때는 키, 값의 쌍인 HashMap에 담아 쓰면 된다
		if(service.isDuplicate(dto))
			map.put("result", "fail");	// 사용중인 아이디
		else
			map.put("result", "success"); // 사용 가능한 아이디
		return map;
	}
	
	@ResponseBody	// jsp로 가지 않고 JSON 형태 데이터 출력용
	@RequestMapping(value="/member/login_proc")
	// HttpSession 객체를 가져오는 HttpServletRequest 객체를 매개변수로 추가
	public Map<String, String> login_proc(MemberDTO dto, HttpServletRequest req){
		Map<String, String> map = new HashMap<String, String>();
		MemberDTO resultDTO = service.login(dto);
		if(resultDTO==null) {	// 데이터가 없어서 안 담김
			map.put("result", "1");
			map.put("message", "존재하지 않는 아이디입니다.");
			return map;
		}
		if(!resultDTO.getM_password().equals(dto.getM_password())) {
			map.put("result", "1");
			map.put("message", "비밀번호가 일치하지 않습니다.");
			return map;
		}
		HttpSession session = req.getSession();
		// 세션 객체를 가져온다
		// 세션은 웹에 접근하는 사용자마다 하나씩 자동으로 객체를 생성한다
		// 세션이 가져온 값을 하나씩 담는다
		session.setAttribute("m_userid", resultDTO.getM_userid());
		session.setAttribute("m_password", resultDTO.getM_password());
		session.setAttribute("m_email", resultDTO.getM_email());
			map.put("result", "0");
			map.put("message", "로그인되었습니다.");
			return map;
		}
	
	@RequestMapping(value="/member/login")
	public String login(){
		// 페이지 이동만 처리
		return "member/login";
		}
	
	@RequestMapping(value="/member/findid")
	public String findid() {
		return "member/findid";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/findid_proc")
	public Map<String, String> findid_proc(MemberDTO dto){
		Map<String, String> map = new HashMap<String, String>();
		MemberDTO resultDTO = service.findid(dto);
		if(resultDTO==null) {	// 데이터가 없어서 안 담김
			map.put("result", "1");
			map.put("message", "존재하지 않는 아이디입니다.");
			return map;
		}
		
		/*
		HttpSession session = req.getSession();
		 * 로그인에 필요한 거라 여기선 상관없음
		 * session.setAttribute("m_userid", resultDTO.getM_userid());
		 * session.setAttribute("m_name", resultDTO.getM_name());
		 * session.setAttribute("m_email", resultDTO.getM_email());
		 */
		map.put("result", "0");
		map.put("message", "해당 아이디를 찾았습니다.");
		map.put("m_userid", resultDTO.getM_userid());
	
		return map;
	}
	
	@RequestMapping(value="/member/findpassword")
	public String findpassword() {
		return "member/findpassword";
	}
	
	@ResponseBody
	@RequestMapping(value="/member/findpassword_proc")
	public Map<String, String> findpassword_proc(MemberDTO dto){
		Map<String, String> map=new HashMap<String, String>();
		MemberDTO resultDTO = service.findpassword(dto);
		if(resultDTO==null) {
			map.put("result", "1");
			map.put("message", "입력값을 확인해 주세요");
			return map;
		}
		
		map.put("result", "0");
		map.put("message", "비밀번호를 찾았습니다.");
		map.put("m_password", resultDTO.getM_password());
		return map;
	}
	
	@ResponseBody
	@RequestMapping(value="/member/list_data")
	public Map<String, Object> list_data(MemberDTO dto){
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("totalCnt", service.getTotalCnt(dto));
		map.put("data", service.getList(dto));
		return map;
	}
	
	@RequestMapping(value="/member/list")
	public String list(Model model, MemberDTO dto) {
		model.addAttribute("totalCnt", service.getTotalCnt(dto));
		return "member/member_list";
	}

}

