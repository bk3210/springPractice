package com.kosa.mycompany.gallery;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


// SqlSessionTemplate 객체가 두 개 동시에 존재할 경우, @Autowired는 두개의 참조중 무엇을 SqlSessionTemplate 객체에 주입해야 할지 구분할 수 없음
// 하지만 @Resource는 name값에 id(객체명)를 지정하면 무엇을 주입해야 할지 구분할 수 있다
@Repository("galleryDAO")
public class GalleryDAOImpl implements GalleryDAO {
	@Autowired
	SqlSessionTemplate sm;

	@Override
	public List<GalleryDTO> getList(GalleryDTO dto) {
		return sm.selectList("Gallery_getList", dto);
	}

	@Override
	public int getTotalCnt(GalleryDTO dto) {
		return sm.selectOne("Gallery_getTotalCnt", dto);
	}

	@Override
	public void insert(GalleryDTO dto) {
		sm.insert("Gallery_insert", dto);
	}

}
