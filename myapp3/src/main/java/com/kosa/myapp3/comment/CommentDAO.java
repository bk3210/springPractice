package com.kosa.myapp3.comment;

import java.util.List;

public interface CommentDAO {
	List<CommentDTO> getComment(CommentDTO dto);
	void insert(CommentDTO dto);

}
