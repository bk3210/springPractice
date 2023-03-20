package com.kosa.mycompany.guestbook;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*<bean id="sm"   class="org.mybatis.spring.SqlSessionTemplate">
<constructor-arg index="0"	ref="sqlSessionFactory" >
</constructor-arg>
</bean>*/
@Repository("guestbookDAO")
public class GuestbookDAOImpl implements GuestbookDAO {
	// org.mybatis.spring.SqlSessionTemplate
	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<GuestbookDTO> getList(GuestbookDTO dto) {

		// "Guestbook_getList" - mapper(Guestbook.xml)에 있는 쿼리의 id
		// dto : parameterType�� ���޵�
		// selectList �޼ҵ�� xml���Ϸκ��� ������ �ҷ��� �����Ų ����� resultType���� ������ ��ü�� �����
		// �� �ȿ� ���� �־� ���� ArrayList��ü�� dto ��ü �߰� �� ��ȯ��
		return sm.selectList("Guestbook_getList", dto);
	}
	
	@Override
	public int getTotalCnt(GuestbookDTO dto) {
		return sm.selectOne("Guestbook_getTotalCnt", dto);
		// 객체 하나만 들고올 때는 selectOne메소드 사용
	}
	
	@Override
	public GuestbookDTO getView(GuestbookDTO dto) {
		return sm.selectOne("Guestbook_getView", dto);
		// 가져올 데이터가 1건이면 selectOne 메소드 호출
	}
	
	@Override
	public void insert(GuestbookDTO dto) {
		sm.insert("Guestbook_insert", dto);
	}
	
	@Override
	public void update(GuestbookDTO dto) {
		sm.insert("Guestbook_update", dto);
	}
		
	@Override
	public void delete(GuestbookDTO dto) {
		sm.delete("Guestbook_delete", dto);
	}
	
}
