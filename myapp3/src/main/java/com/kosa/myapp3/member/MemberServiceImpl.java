package com.kosa.myapp3.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosa.myapp3.mapper.MemberMapper;

@Service("memberService")
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberMapper memberDAO;
	
	@Override
	public void Member_insert(MemberDTO dto) {
		memberDAO.Member_insert(dto);
	}
	
	@Override
	public boolean isUse(MemberDTO dto) {
		// 사용 가능한 아이디일 때(아이디 중복이 없으면) true
		// 사용 불가능한 아이디면 false 반환
		int result = memberDAO.Member_idcheck(dto);
		if(result==0) {
			return true;
		}
			return false;			
	}
	
	@Override
	public MemberDTO Member_login(MemberDTO dto) {
		return memberDAO.Member_login(dto);
	}
}
