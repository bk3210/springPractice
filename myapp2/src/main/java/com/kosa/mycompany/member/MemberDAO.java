package com.kosa.mycompany.member;

import java.util.List;

// interface에서는 접근제어자 안 쓰면 전부 public
public interface MemberDAO {
	public void insert(MemberDTO dto);
	public boolean isDuplicate(MemberDTO dto);
	MemberDTO login(MemberDTO dto);
	MemberDTO findid(MemberDTO dto);
	MemberDTO findpassword(MemberDTO dto);
	List<MemberDTO> getList(MemberDTO dto);
	int getTotalCnt(MemberDTO dto);
}
