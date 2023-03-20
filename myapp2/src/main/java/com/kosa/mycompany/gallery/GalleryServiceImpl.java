package com.kosa.mycompany.gallery;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("galleryService")
public class GalleryServiceImpl implements GalleryService {
	
	@Resource(name="galleryDAO")
	GalleryDAO galleryDAO;

	@Override
	public List<GalleryDTO> getList(GalleryDTO dto) {
		return galleryDAO.getList(dto);
	}

	@Override
	public int getTotalCnt(GalleryDTO dto) {
		return galleryDAO.getTotalCnt(dto);
	}

	@Override
	public void insert(GalleryDTO dto) {
		galleryDAO.insert(dto);
	}
	

}
