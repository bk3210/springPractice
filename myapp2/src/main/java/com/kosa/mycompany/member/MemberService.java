package com.kosa.mycompany.member;

import java.util.List;

public interface MemberService {
	void insert(MemberDTO dto);
	boolean isDuplicate(MemberDTO dto);
	MemberDTO login(MemberDTO dto);
	MemberDTO findid(MemberDTO dto);
	MemberDTO findpassword(MemberDTO dto);
	List<MemberDTO> getList(MemberDTO dto);
	int getTotalCnt(MemberDTO dto);

}
