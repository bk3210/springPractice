package com.kosa.mycompany.gallery;

import java.util.List;

public interface GalleryService {
	List<GalleryDTO> getList(GalleryDTO dto);
	int getTotalCnt(GalleryDTO dto);
	void insert(GalleryDTO dto);

}
