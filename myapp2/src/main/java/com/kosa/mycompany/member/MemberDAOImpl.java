package com.kosa.mycompany.member;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Autowired
	SqlSessionTemplate sm;
	// sql 객체를 가져오는 클래스(Spring이 아니라 MyBatis가 제공함!!)
	
	@Override
	public void insert(MemberDTO dto) {
		sm.insert("Member_insert", dto);
	}
	
	@Override
	public boolean isDuplicate(MemberDTO dto) {
		int result = sm.selectOne("Member_idcheck", dto);
		if(result==0) 
			return false;
		else 
			return true;
		
	}
	
	@Override
	public MemberDTO login(MemberDTO dto) {
		return sm.selectOne("Member_login", dto);
		// 가져올 sql 객체가 하나뿐이면 selectOne
	}
	
	@Override
	public MemberDTO findid(MemberDTO dto) {
		return sm.selectOne("Member_findid", dto);
	}
	
	@Override
	public MemberDTO findpassword(MemberDTO dto) {
		return sm.selectOne("Member_findpassword", dto);
	}
	
	@Override
	public List<MemberDTO> getList(MemberDTO dto) {
		return sm.selectList("Member_listdata", dto);
	}
	
	@Override
	public int getTotalCnt(MemberDTO dto) {
		return sm.selectOne("Member_getTotalCnt", dto);
	}
}
