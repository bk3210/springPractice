package com.kosa.myapp3.comment;

import java.util.List;

public interface CommentService {
	// int getTotalCnt(CommentDTO dto);
	List<CommentDTO> getComment(CommentDTO dto);
	void insert(CommentDTO dto);

}
