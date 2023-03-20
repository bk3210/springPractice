package com.kosa.myapp3.comment;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("commentDAO")
public class CommentDAOImpl implements CommentDAO{

	@Autowired
	SqlSessionTemplate sm;
	
	@Override
	public List<CommentDTO> getComment(CommentDTO dto) {
		return sm.selectList("Comment_getComment", dto);
	}

	@Override
	public void insert(CommentDTO dto) {
		sm.insert("Comment_insert", dto);
	}

}
