package com.kosa.myapp3.member;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
	@Resource(name="memberService")
	MemberService memberService;
	
	@ResponseBody
	@RequestMapping("/member/save")
	public Map<String, Object> member_save(MemberDTO dto){
		memberService.Member_insert(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", "success");
		map.put("msg", "회원가입에 성공했습니다.");
		
		return map;
	}
	
	@RequestMapping("/member/write")
	// dto 매개변수는 있든말든 상관ㄴㄴ(나중에 쓸 일이 있을까봐 적어둔 것)
	public String member_write(MemberDTO dto) {
		return "member/member";
	}
	
	@ResponseBody
	@RequestMapping("/member/isuse")
	public Map<String, Object> member_isuse(MemberDTO dto){
		Map<String, Object> map = new HashMap<String, Object>();
		if(memberService.isUse(dto)) {
			map.put("result", "success");
			map.put("msg", "사용 가능한 아이디입니다.");
		}else {
			map.put("result", "fail");
			map.put("msg", "이미 사용중인 아이디입니다.");
		}
		return map;
	}
	
	
	@RequestMapping("/member/login")
	public String member_login(MemberDTO dto) {
		return "member/login";
	}
	
	// 세션 객체는 사용자가 브라우저를 통해 서버로 접근 요청이 발생할 때마다 각 사용자에게 새로 생성한다
	// 이 세션은 시스템이 생성하는 것이고, 우리는 그것을 getSession을 통해 가져오기만 하면 된다
	@ResponseBody
	@RequestMapping("/member/go_login")
	public Map<String, Object> member_login(MemberDTO dto, HttpServletRequest request){
		Map<String, Object> map = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		MemberDTO resultDTO = memberService.Member_login(dto);
		if(resultDTO==null) {
			map.put("result", "fail");
			map.put("msg", "아이디를 다시 확인해 주세요.");
			return map;	// 여기서 메소드 종료
		}
		
		if(!resultDTO.getPassword().equals(dto.getPassword())) {
			map.put("result", "fail");
			map.put("msg", "패스워드가 일치하지 않습니다.");
			return map;
		}
		
		// 로그인 성공시 session에 로그인 정보를 저장
		// 세션에 너무 많은 정보를 저장하면 시스템에 과부하가 걸린다
		session.setAttribute("user_id", resultDTO.getUser_id());
		session.setAttribute("user_name", resultDTO.getUser_name());
		session.setAttribute("email", resultDTO.getEmail());
		
		map.put("result", "success");
		map.put("msg", "로그인에 성공했습니다");
		return map;
	}
	
	@RequestMapping("/member/go_logout")
	public String member_logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();	// 세션에 담긴 정보 삭제
		return "redirect:/home";
	}
	

}