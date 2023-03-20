package com.kosa.mycompany.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	MemberDAO memberDAO;

	@Override
	public void insert(MemberDTO dto) {
		memberDAO.insert(dto);
	}

	@Override
	public boolean isDuplicate(MemberDTO dto) {
		return memberDAO.isDuplicate(dto);
	}

	@Override
	public MemberDTO login(MemberDTO dto) {
		return memberDAO.login(dto);
	}

	@Override
	public MemberDTO findid(MemberDTO dto) {
		return memberDAO.findid(dto);
	}
	
	@Override
	public MemberDTO findpassword(MemberDTO dto) {
		return memberDAO.findpassword(dto);
	}
	
	@Override
	public List<MemberDTO> getList(MemberDTO dto) {
	return memberDAO.getList(dto);
	}
	
	@Override
	public int getTotalCnt(MemberDTO dto) {
		return memberDAO.getTotalCnt(dto);
	}
}
