package com.kosa.mycompany.guestbook;

import java.util.List;

public interface GuestbookDAO {
	List<GuestbookDTO> getList(GuestbookDTO dto);
	int getTotalCnt(GuestbookDTO dto);
	GuestbookDTO getView(GuestbookDTO dto);
	void insert(GuestbookDTO dto);
	void update(GuestbookDTO dto);
	void delete(GuestbookDTO dto);
}
