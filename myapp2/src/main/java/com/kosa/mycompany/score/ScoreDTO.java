package com.kosa.mycompany.score;

import com.kosa.mycompany.common.BaseDTO;

public class ScoreDTO extends BaseDTO {
	private String seq="";
	private String name="";
	private String kor="";
	private String mat="";
	private String eng="";
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKor() {
		return kor;
	}
	public void setKor(String kor) {
		this.kor = kor;
	}
	public String getMat() {
		return mat;
	}
	public void setMat(String mat) {
		this.mat = mat;
	}
	public String getEng() {
		return eng;
	}
	public void setEng(String eng) {
		this.eng = eng;
	}
	
}
