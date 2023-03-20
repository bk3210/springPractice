package com.kosa.myapp3.comment;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("commentService")
public class CommentServiceImpl implements CommentService {

	@Resource(name="commentDAO")
	CommentDAO commentDAO;
	
	/*
	 * @Override public int getTotalCnt(CommentDTO dto) { return
	 * commentDAO.getTotalCnt(dto); }
	 */
	
	@Override
	public List<CommentDTO> getComment(CommentDTO dto) {
		return commentDAO.getComment(dto);
	}

	@Override
	public void insert(CommentDTO dto) {
		commentDAO.insert(dto);
	}
}
