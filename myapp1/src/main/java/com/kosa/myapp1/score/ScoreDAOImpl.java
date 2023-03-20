package com.kosa.myapp1.score;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

// 객체를 참조하면 ScoreDAO를 찾아가겠다는 어노테이션
@Repository("scoreDAO")
public class ScoreDAOImpl implements ScoreDAO {
	List<ScoreDTO> list = new ArrayList<ScoreDTO>();
	
	public ScoreDAOImpl() {
		list.add(new ScoreDTO("1", "홍길동", "100", "100", "100"));
		list.add(new ScoreDTO("2", "김길동", "90", "90", "90"));
		list.add(new ScoreDTO("3", "이길동", "80", "80", "80"));
		list.add(new ScoreDTO("4", "박길동", "70", "70", "70"));
		list.add(new ScoreDTO("5", "최길동", "60", "60", "60"));
		
		}

	@Override
	public List<ScoreDTO> getList(ScoreDTO dto) {
		return list;
	}

	@Override
	public ScoreDTO getView(String seq) {
		for(int i=0; i<list.size(); i++) {
			if(list.get(i).getSeq().equals(seq)) {
				return list.get(i);
			}
		}
		return new ScoreDTO();
	}

	@Override
	public void insert(ScoreDTO dto) {
		list.add(dto);
	}

	@Override
	public void update(ScoreDTO dto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ScoreDTO dto) {
		// TODO Auto-generated method stub
		
	}
	}

