package com.kosa.mycompany.guestbook;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("guestbookService")
public class GuestbookServiceImpl implements GuestbookService {

	@Resource(name="guestbookDAO")
	GuestbookDAO dao;
	
	@Override
	public List<GuestbookDTO> getList(GuestbookDTO dto) {
		return dao.getList(dto);
	}
	
	@Override
	public int getTotalCnt(GuestbookDTO dto) {
		return dao.getTotalCnt(dto);
		// dao를 통해 접근
	}

	@Override
	public GuestbookDTO getView(GuestbookDTO dto) {
		return dao.getView(dto);
	}

	@Override
	public void insert(GuestbookDTO dto) {
		dao.insert(dto);
		
	}

	@Override
	public void update(GuestbookDTO dto) {
		dao.update(dto);
		
	}

	@Override
	public void delete(GuestbookDTO dto) {
		dao.delete(dto);
	}


}