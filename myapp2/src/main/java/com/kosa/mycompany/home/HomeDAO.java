package com.kosa.mycompany.home;

import java.util.List;

public interface HomeDAO {
	List<HomeDTO> homeList(HomeDTO dto);
	void insert(HomeDTO dto);
}
