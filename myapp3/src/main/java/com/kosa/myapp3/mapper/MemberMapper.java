package com.kosa.myapp3.mapper;

import com.kosa.myapp3.member.MemberDTO;

public interface MemberMapper {
	public void Member_insert(MemberDTO dto);
	public int Member_idcheck(MemberDTO dto);
	public MemberDTO Member_login(MemberDTO dto);
}
