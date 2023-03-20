package com.kosa.myapp3.member;

public interface MemberService {
	public void Member_insert(MemberDTO dto);
	// DAO랑 꼭 메소드 형식이 같아야 할 필요는 없다
	public boolean isUse(MemberDTO dto);	// Member_idcheck(MemberDTO dto);
	public MemberDTO Member_login(MemberDTO dto);

}
