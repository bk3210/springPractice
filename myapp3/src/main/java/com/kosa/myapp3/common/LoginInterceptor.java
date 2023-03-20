package com.kosa.myapp3.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


// HandlerInterceptorAdapter를 상속받아야 인터셉터 구현 가능
public class LoginInterceptor extends HandlerInterceptorAdapter {
	
	// 만약 /board/write url 호출 -> LoginInterceptor의 preHandle을 거쳐간다
	// 로그인 여부에 따라 로그인 페이지를 호출할지, Controller로 보내 요청받은 작업을 수행할지 결정한다
	
	// preHandler : 컨트롤러가 호출되기 전 수행
	// postHandler : 컨트롤러가 동작 완료된 후 수행
	// afterCompletion : 컨트롤러 수행 후 view단 작업까지 모두 완료된 후 호출
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// 세션 객체를 가져와서 로그인 여부를 판단
		HttpSession session = request.getSession();
		System.out.println("인터셉터 : 모두 여기를 거쳐감.************************************");
		// 로그인하지 않았을 때에도 접근 가능한 url 목록
		List<String> excludeCheckList=new ArrayList<String>();
		excludeCheckList.add("/member/login");
		excludeCheckList.add("/member/go_login");
		excludeCheckList.add("/member/write");
		excludeCheckList.add("/board/list");
		excludeCheckList.add("/board/view");
		excludeCheckList.add("/");
		
		String email = (String) session.getAttribute("email");
		String currentUrl = request.getRequestURI();
		System.out.println(currentUrl+"******************************************************");
		if(email==null || email.equals("")) {
			currentUrl = currentUrl.substring(request.getContextPath().length());
			System.out.println(currentUrl);
			
			// 만약 리스트에 없는 url을 호출할 때 로그인 페이지로 이동시킴
			if(excludeCheckList.indexOf(currentUrl)==-1) {
				// 로그인 되지 않은 상태(세션 객체에 아무런 정보도 저장되어 있지 않은 상태)
				String url=request.getContextPath()+"/member/login";
				response.sendRedirect(url);
				return false;	// 메소드 종료를 시키지 않으면 아래로 쭉 내려가서 동작을 실행시키고 만다
			}
		}
		
		// 부모 클래스의 메소드를 호출해야 한다
		return super.preHandle(request, response, handler);

	}
}
